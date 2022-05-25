package com.step.tourist_agency.repository;

import com.step.tourist_agency.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findOneById(Long id);
}
