package com.bank.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.customer.model.Account;
import com.bank.customer.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> createMultipleAccount(List<Account> accounts) {
			return accountRepository.saveAll(accounts);
	}

	@Override
	public Account updateAccount(Long id, Account updatedAccount) {
		Account existing = accountRepository.findById(id).orElseThrow(()->new RuntimeException("account not found"));
		if(updatedAccount.getAccountNumber()!=null) {
			existing.setAccountNumber(updatedAccount.getAccountNumber());
		}
		if(updatedAccount.getAccountType()!=null) {
			existing.setAccountType(updatedAccount.getAccountType());
		}
	
		return accountRepository.save(existing);
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
		
	}

	@Override
	public Account getAccountById(Long id) {
		return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid Account"));
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	

}
