package com.step.tourist_agency.dto;

import com.step.tourist_agency.dto.parent.NameDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto extends NameDto {

    private LogDto log;
}
