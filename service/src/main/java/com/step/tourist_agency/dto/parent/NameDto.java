package com.step.tourist_agency.dto.parent;


import lombok.Getter;
import lombok.Setter;

/**
 * не является абстрактным на случай передачи всего двух полей
 */
@Getter
@Setter
public class NameDto extends BaseDto {

    private String name;
}