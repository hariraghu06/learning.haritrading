package com.example.learning.haritrading.controller;

import com.example.learning.haritrading.model.CustomerDetails;
import com.example.learning.haritrading.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/newCustomer")
    public String addNewCustomer(@RequestBody CustomerDetails customerDetailsInput) {
        String message;
        try {
            customerRepository.save(customerDetailsInput);
            message = "Customer details saved successfully";
        } catch (Exception e) {
            message = " Customer ID " + customerDetailsInput.getCustomerId() + "is already present";
        }

        return message;
    }
}
