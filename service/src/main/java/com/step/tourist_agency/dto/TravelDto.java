package com.step.tourist_agency.dto;

import com.step.tourist_agency.dto.parent.NameDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TravelDto extends NameDto {

    private LogDto log;
}
