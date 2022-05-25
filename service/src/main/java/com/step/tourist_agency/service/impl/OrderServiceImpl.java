package com.step.tourist_agency.service.impl;

import com.step.tourist_agency.converter.OrderConverter;
import com.step.tourist_agency.dto.OrderDto;
import com.step.tourist_agency.dto.OrderTravelDto;
import com.step.tourist_agency.entity.Order;
import com.step.tourist_agency.exception.EntityNotFoundException;
import com.step.tourist_agency.repository.OrderRepository;
import com.step.tourist_agency.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    public OrderServiceImpl(OrderRepository orderRepository, OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
    }

//-----------------------------------------------------------------------------------------------------------------------------

    @Override
    public OrderDto findOne(Long id) {
        return orderConverter.convert(
                orderRepository.findOneById(id).orElseThrow(
                        () -> new EntityNotFoundException("Order not found by id: " + id)
                )
        );
    }

    @Override
    public OrderTravelDto findOneFull(Long id) {
        return orderConverter.convertFull(
                orderRepository.findOneById(id).orElseThrow(
                        () -> new EntityNotFoundException("Order not found by id: " + id)
                )
        );
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.size() == 0 ?
                Collections.emptyList() :
                orderList.stream().map(orderConverter::convert).collect(Collectors.toList());
    }


    @Override
    public List<OrderTravelDto> findAllFull() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.size() == 0 ?
                Collections.emptyList() :
                orderList.stream().map(orderConverter::convertFull).collect(Collectors.toList());
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        return orderConverter.convert(
                orderRepository.save(
                        orderConverter.convert(orderDto)
                )
        );
    }


    @Override
    public void remove(Long id) {
        orderRepository.deleteById(id);
    }

}