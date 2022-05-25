package com.step.tourist_agency.controller.impl;

import com.step.tourist_agency.controller.CustomerController;
import com.step.tourist_agency.dto.CustomerDto;
import com.step.tourist_agency.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/castomers")
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<CustomerDto> findOne(Long id) {
        return new ResponseEntity<>(customerService.findOne(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CustomerDto>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerDto> save(CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.save(customerDto), HttpStatus.OK);
    }

    @Override
    public void remove(Long id) {
        customerService.remove(id);
    }
}
