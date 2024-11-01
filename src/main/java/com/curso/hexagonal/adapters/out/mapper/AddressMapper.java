package com.curso.hexagonal.adapters.out.mapper;

import org.modelmapper.ModelMapper;

import com.curso.hexagonal.adapters.out.client.response.AddressResponse;
import com.curso.hexagonal.application.core.domain.Address;

public class AddressMapper {
    
    public static Address toAddress(AddressResponse addressResponse) {
        return new ModelMapper().map(addressResponse, Address.class);
    }

}
