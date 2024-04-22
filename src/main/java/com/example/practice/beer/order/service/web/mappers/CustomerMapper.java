package com.example.practice.beer.order.service.web.mappers;

import com.example.practice.beer.order.service.domain.Customer;
import com.example.practice.beer.order.service.web.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = DateMapper.class)
public interface CustomerMapper {
    @Mapping(target = "id", source = "customer.id")
    @Mapping(target = "name", source = "customer.customerName")
    CustomerDto customerToCustomerDto(Customer customer);
}
