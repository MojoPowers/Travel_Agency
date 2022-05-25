package com.step.tourist_agency.service;

import com.step.tourist_agency.dto.TravelDto;

import java.util.List;

public interface TravelService {

    TravelDto findOne(Long id);

    List<TravelDto> findAll(Integer pageNumber, Integer pageSize, String sortBy);

    List<TravelDto> findAllByOrder(Long orderId);

    TravelDto save(TravelDto travelDto);

    void remove(Long id);

}