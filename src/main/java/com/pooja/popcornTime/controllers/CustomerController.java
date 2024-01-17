package com.jatin.popcornTime.controllers;

import com.jatin.popcornTime.dtos.CreateCustomerDTO;
import com.jatin.popcornTime.models.Customer;
import com.jatin.popcornTime.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody CreateCustomerDTO customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

}
