package com.curso.hexagonal.application.ports.out;

import com.curso.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address execute(String zipCode);
    
}
