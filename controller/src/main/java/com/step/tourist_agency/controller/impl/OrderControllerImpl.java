package com.step.tourist_agency.controller.impl;

import com.step.tourist_agency.controller.OrderController;
import com.step.tourist_agency.dto.OrderDto;
import com.step.tourist_agency.dto.OrderTravelDto;
import com.step.tourist_agency.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ordsers")
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    public OrderControllerImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<OrderDto> findOne(Long id) {
        return new ResponseEntity<>(orderService.findOne(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderTravelDto> findOneFull(Long id) {
        return new ResponseEntity<>(orderService.findOneFull(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderDto>> findAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderTravelDto>> findAllFull() {
        return new ResponseEntity<>(orderService.findAllFull(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> save(OrderDto orderDto) {
        return new ResponseEntity<>(orderService.save(orderDto), HttpStatus.OK);
    }

    @Override
    public void remove(Long id) {
        orderService.remove(id);
    }
}
