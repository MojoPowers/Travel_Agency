package com.step.tourist_agency.service.impl;

import com.step.tourist_agency.converter.CustomerConverter;
import com.step.tourist_agency.dto.CustomerDto;
import com.step.tourist_agency.entity.Customer;
import com.step.tourist_agency.exception.EntityNotFoundException;
import com.step.tourist_agency.repository.CustomerRepository;
import com.step.tourist_agency.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerConverter customerConverter) {
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
    }

    //------------------------------------------------------------------------------------------

    @Override
    public CustomerDto findOne(Long id) {
        return customerConverter.convert(
                customerRepository.findOneById(id).orElseThrow(
                        () -> new EntityNotFoundException("Customer not found by id: " + id)
                )
        );
    }

    @Override
    public List<CustomerDto> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.size() == 0 ?
                Collections.emptyList() :
                customerList.stream().map(customerConverter::convert).collect(Collectors.toList());
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerConverter.convert(
                customerRepository.save(
                        customerConverter.convert(customerDto)
                )
        );
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

}