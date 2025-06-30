package com.bank.customer.service;

import java.util.List;

import com.bank.customer.model.Account;

public interface AccountService {
	
	Account createAccount(Account account);
	List<Account> createMultipleAccount(List<Account> accounts);
	
	Account updateAccount(Long id, Account updatedAccount);
	
	void deleteAccount(Long id);
	
	Account getAccountById(Long id);
	List<Account> getAllAccount();

}
