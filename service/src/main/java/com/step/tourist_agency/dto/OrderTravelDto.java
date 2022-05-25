package com.step.tourist_agency.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderTravelDto extends OrderDto {

    private List<TravelDto> travels;
}
