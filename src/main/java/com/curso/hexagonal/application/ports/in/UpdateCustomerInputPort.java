package com.curso.hexagonal.application.ports.in;

import com.curso.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    
    Customer update(Long id, Customer customer, String zipcode);

}
