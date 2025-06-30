package com.bank.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
