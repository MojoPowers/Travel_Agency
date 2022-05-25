package com.step.tourist_agency.controller;

import com.step.tourist_agency.dto.TravelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TravelController {

    @GetMapping("/one")
    ResponseEntity<TravelDto> findOne(@RequestParam("id") Long id);

    @GetMapping("/allByOrder")
    ResponseEntity<List<TravelDto>> findAllByOrder(@RequestParam("orderId") Long orderId);

    @GetMapping("/all")
    ResponseEntity<List<TravelDto>> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                            @RequestParam(defaultValue = "type") String sortBy);

    @PostMapping("/save")
    ResponseEntity<TravelDto> save(@RequestBody TravelDto travelDto);

    @DeleteMapping("/remove")
    void remove(@RequestParam("id") Long id);
}