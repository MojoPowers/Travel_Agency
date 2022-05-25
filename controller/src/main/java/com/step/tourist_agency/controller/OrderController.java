package com.step.tourist_agency.controller;

import com.step.tourist_agency.dto.OrderDto;
import com.step.tourist_agency.dto.OrderTravelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface OrderController {

    @GetMapping("/one")
    ResponseEntity<OrderDto> findOne(@RequestParam("id") Long id);

    @GetMapping("/one/full")
    ResponseEntity<OrderTravelDto> findOneFull(@RequestParam("id") Long id);

    @GetMapping("/all")
    ResponseEntity<List<OrderDto>> findAll();

    @GetMapping("/all/full")
    ResponseEntity<List<OrderTravelDto>> findAllFull();

    @PostMapping("/save")
    ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto);

    @DeleteMapping("/remove")
    void remove(@RequestParam("id") Long id);
}