package com.jatin.popcornTime.repositories;

import com.jatin.popcornTime.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByPhone(String phone);

    Optional<Customer> findCustomerByEmail(String email);

    List<Customer> findAllByEmailContaining(String containingWord);
}
