package com.curso.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.hexagonal.adapters.out.mapper.CustomerMapper;
import com.curso.hexagonal.adapters.out.persistence.entities.CustomerEntity;
import com.curso.hexagonal.adapters.out.persistence.repositories.CustomerRepository;
import com.curso.hexagonal.application.core.domain.Customer;
import com.curso.hexagonal.application.ports.out.CustomerOutputPort;

@Component
public class CustomerAdapter implements CustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void create(Customer customer) {
        customerRepository.save(CustomerMapper.toCustomerEntity(customer));
    }

    @Override
    public Customer findById(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id).orElse(null);
        if (customerEntity == null) return null;
        return CustomerMapper.toCustomerDomain(customerEntity);
    }

    @Override
    public Customer update(Customer customer) {
        CustomerEntity customerEntity = CustomerMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
        return CustomerMapper.toCustomerDomain(customerEntity);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
    
}
