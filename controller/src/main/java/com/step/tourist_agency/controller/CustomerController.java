package com.step.tourist_agency.controller;

import com.step.tourist_agency.dto.CustomerDto;
import com.step.tourist_agency.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerController {

    @GetMapping("/one")
    ResponseEntity<CustomerDto> findOne(@RequestParam("id") Long id);

    @GetMapping("/all")
    ResponseEntity<List<CustomerDto>> findAll();

    @PostMapping("/save")
    ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto);

    @DeleteMapping("/remove")
    void remove(@RequestParam("id") Long id);
}