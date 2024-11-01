package com.curso.hexagonal.adapters.out.mapper;

import org.modelmapper.ModelMapper;

import com.curso.hexagonal.adapters.out.persistence.entities.CustomerEntity;
import com.curso.hexagonal.application.core.domain.Customer;

public class CustomerMapper {
    
    public static CustomerEntity toCustomerEntity(Customer customer) {
        return new ModelMapper().map(customer, CustomerEntity.class);
    }
    
    public static Customer toCustomerDomain(CustomerEntity customerEntity) {
        return new ModelMapper().map(customerEntity, Customer.class);
    }

}
