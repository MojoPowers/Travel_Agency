package com.step.tourist_agency.converter;

import com.step.tourist_agency.converter.customer.DateTimeMapper;
import com.step.tourist_agency.dto.CustomerDto;
import com.step.tourist_agency.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {
        DateTimeMapper.class
})
public interface CustomerConverter {

    Customer convert(CustomerDto source);

    @Mapping(source = "dateCreation", target = "log.dateCreation")
    @Mapping(source = "lastModified", target = "log.lastModified")
    @Mapping(source = "version", target = "log.version")
    CustomerDto convert(Customer source);
}