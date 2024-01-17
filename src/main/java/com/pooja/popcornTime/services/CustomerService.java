package com.jatin.popcornTime.services;

import com.jatin.popcornTime.dtos.CreateCustomerDTO;
import com.jatin.popcornTime.dtos.CreateUserDTO;
import com.jatin.popcornTime.models.Customer;
import com.jatin.popcornTime.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.jatin.popcornTime.models.User;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserService userService;

    public Customer createCustomer(CreateCustomerDTO customerRequest) {
        if (userService.doesUserExist(customerRequest.getUsername(), customerRequest.getEmail())) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = userService.createUser(
                new CreateUserDTO(customerRequest.getUsername(), customerRequest.getPassword(), "CUSTOMER"));

        Customer customer = Customer
                .builder()
                .city(customerRequest.getCity())
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .user(user)
                .build();
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository.getById(customerId);
    }

}