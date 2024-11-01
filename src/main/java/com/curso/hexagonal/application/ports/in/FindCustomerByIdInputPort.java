package com.curso.hexagonal.application.ports.in;

import com.curso.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(Long id);
    
}
