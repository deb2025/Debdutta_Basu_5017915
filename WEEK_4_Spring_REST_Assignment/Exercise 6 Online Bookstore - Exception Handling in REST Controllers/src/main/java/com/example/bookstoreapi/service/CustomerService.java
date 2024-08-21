package com.example.bookstoreapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreapi.model.Customer;
import com.example.bookstoreapi.repository.CustomerRepository;

@Service
//To define the CRUD operations CutomerService class is defined
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
