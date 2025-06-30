package com.bank.customer.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.customer.model.Account;
import com.bank.customer.service.AccountService;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	@PostMapping("/batch")
	public List<Account> createMultipleAccount(@RequestBody List<Account> accounts){
		return accountService.createMultipleAccount(accounts);
	}
	
   @PutMapping("/{id}")
   public Account updateAccount(@PathVariable Long id, @RequestBody Account updateAccount) {
	   return accountService.updateAccount(id, updateAccount);
   }
   
   @GetMapping
   public List<Account> getAllAccounts(){
	   return accountService.getAllAccount();
   }
   
   @GetMapping("/{id}")
   public Account getAccountById(@PathVariable Long id) {
	   return accountService.getAccountById(id);
   }
   
   @DeleteMapping("/{id}")
   public void deleteAccountById(@PathVariable Long id) {
	   accountService.deleteAccount(id);
   }
}
