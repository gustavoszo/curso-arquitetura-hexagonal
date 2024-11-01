package com.curso.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.hexagonal.adapters.out.client.FindAddressByZipcodeClient;
import com.curso.hexagonal.adapters.out.client.response.AddressResponse;
import com.curso.hexagonal.adapters.out.mapper.AddressMapper;
import com.curso.hexagonal.application.core.domain.Address;
import com.curso.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipcodeClient findAddressByZipcodeClient;

    @Override
    public Address execute(String zipCode) {
        AddressResponse addressResponse = findAddressByZipcodeClient.getByZipcode(zipCode);
        return AddressMapper.toAddress(addressResponse);
    }
    
}
