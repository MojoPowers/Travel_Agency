package com.step.tourist_agency.service;

import com.step.tourist_agency.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto findOne(Long id);

    List<CustomerDto> findAll();

    CustomerDto save(CustomerDto customerDto);

    void remove(Long id);

}