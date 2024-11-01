package com.curso.hexagonal.application.ports.out;


import com.curso.hexagonal.application.core.domain.Customer;

public interface CustomerOutputPort {

    void create(Customer customer);
    Customer findById(Long id);
    Customer update(Customer customer);
    void deleteById(Long id);
    
}
