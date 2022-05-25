package com.step.tourist_agency.repository;

import com.step.tourist_agency.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOneById(Long id);
}
