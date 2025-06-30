package com.bank.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerService;

@RestController
@RequestMapping("api/customers")

public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
		
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable Long id,@RequestBody Customer updatedCustomer) {
		return customerService.updateCustomer(id, updatedCustomer);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("/batch")
	public List<Customer> createMulitpleCustomer(@RequestBody List<Customer> customers){
		return customerService.createMultipleCustomer(customers);
	}
	
}
