package com.step.tourist_agency.repository;

import com.step.tourist_agency.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    Optional<Travel> findOneById(Long id);

}