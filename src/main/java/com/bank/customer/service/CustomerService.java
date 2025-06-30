package com.bank.customer.service;

import java.util.List;

import com.bank.customer.model.Customer;

public interface CustomerService {
	
	Customer createCustomer(Customer customer);
	List<Customer> createMultipleCustomer(List<Customer> customers);
	Customer updateCustomer(Long customer_id, Customer customer);
	
	void deleteCustomer(Long id);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerById(Long id);
	

}
