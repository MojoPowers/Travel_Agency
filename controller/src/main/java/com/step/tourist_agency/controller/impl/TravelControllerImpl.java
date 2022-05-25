package com.step.tourist_agency.controller.impl;

import com.step.tourist_agency.controller.TravelController;
import com.step.tourist_agency.dto.TravelDto;
import com.step.tourist_agency.service.TravelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/travels")
public class TravelControllerImpl implements TravelController {

    private final TravelService travelService;

    public TravelControllerImpl(TravelService travelService) {
        this.travelService = travelService;
    }

    @Override
    public ResponseEntity<TravelDto> findOne(Long id) {
        return new ResponseEntity<>(travelService.findOne(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TravelDto>> findAllByOrder(Long orderId) {
        return new ResponseEntity<>(travelService.findAllByOrder(orderId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TravelDto>> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        return new ResponseEntity<>(travelService.findAll(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TravelDto> save(TravelDto travelDto) {
        return new ResponseEntity<>(travelService.save(travelDto), HttpStatus.OK);
    }

    @Override
    public void remove(Long id) {
        travelService.remove(id);
    }
}
