package com.step.tourist_agency.dto;


import com.step.tourist_agency.dto.parent.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto extends BaseDto {

    private CustomerDto customer;
    private LogDto log;
}