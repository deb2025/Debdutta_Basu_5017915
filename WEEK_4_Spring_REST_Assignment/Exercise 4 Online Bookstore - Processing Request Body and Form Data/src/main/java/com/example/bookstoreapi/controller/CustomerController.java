package com.example.bookstoreapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookstoreapi.model.Customer;
import com.example.bookstoreapi.service.CustomerService;

@RestController
@RequestMapping("/api/customers")

//Customer Controller class required to test REST endpoints
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    // Existing JSON request body endpoint
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }
    
    // New form data endpoint
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestParam String name,
                                                     @RequestParam String email,
                                                     @RequestParam String address,
                                                     @RequestParam MultipartFile profilePicture) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        Customer savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }
}