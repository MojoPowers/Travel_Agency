package com.step.tourist_agency.converter;

import com.step.tourist_agency.converter.customer.DateTimeMapper;
import com.step.tourist_agency.dto.TravelDto;
import com.step.tourist_agency.entity.Travel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        DateTimeMapper.class
})
public interface TravelConverter {

    Travel convert(TravelDto source);

    @Mapping(source = "dateCreation", target = "log.dateCreation")
    @Mapping(source = "lastModified", target = "log.lastModified")
    @Mapping(source = "version", target = "log.version")
    TravelDto convert(Travel source);
}