package com.curso.hexagonal.adapters.in.controller.dto.mapper;

import org.modelmapper.ModelMapper;

import com.curso.hexagonal.adapters.in.controller.dto.CustomerRequestDto;
import com.curso.hexagonal.adapters.in.controller.dto.CustomerResponseDto;
import com.curso.hexagonal.application.core.domain.Customer;

public class CustomerMapper {
    
    public static Customer toCustomer(CustomerRequestDto dto) {
        return new ModelMapper().map(dto, Customer.class);
    }
    
    public static CustomerResponseDto toCustomerResponseDto(Customer customer) {
        return new ModelMapper().map(customer, CustomerResponseDto.class);
    }

}
