package com.bank.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.customer.model.Account;
import com.bank.customer.model.Customer;
import com.bank.customer.repository.AccountRepository;
import com.bank.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	private AccountRepository accountRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Long customer_id, Customer updatedCustomer) {
		Customer existing = customerRepository.findById(customer_id).orElseThrow(()->new RuntimeException("customer not found"));
		 if (updatedCustomer.getName() != null) {
		        existing.setName(updatedCustomer.getName());
		    }

		    if (updatedCustomer.getEmail() != null) {
		        existing.setEmail(updatedCustomer.getEmail());
		    }

		    if (updatedCustomer.getPhone() != null) {
		        existing.setPhone(updatedCustomer.getPhone());
		    }
		    if(updatedCustomer.getAccount()!=null) {
		    	String accNo = updatedCustomer.getAccount().getAccountNumber();
		    	
		    	Account account = accountRepository.findByAccountNumber(accNo).orElse(updatedCustomer.getAccount());
		    			
		    	existing.setAccount(account);
		    }
		return customerRepository.save(existing);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(()->new RuntimeException("customer not found"));
		
	}

	@Override
	public List<Customer> createMultipleCustomer(List<Customer> customers) {
		
		return customerRepository.saveAll(customers);
	}
}
