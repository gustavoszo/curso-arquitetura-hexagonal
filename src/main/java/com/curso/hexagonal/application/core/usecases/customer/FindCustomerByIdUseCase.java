package com.curso.hexagonal.application.core.usecases.customer;

import com.curso.hexagonal.application.core.domain.Customer;
import com.curso.hexagonal.application.core.exceptions.EntityNotFoundException;
import com.curso.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.curso.hexagonal.application.ports.out.CustomerOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    CustomerOutputPort customerOutputPort;

    public FindCustomerByIdUseCase(CustomerOutputPort customerOutputPort) {
        this.customerOutputPort = customerOutputPort;
    }

    @Override
    public Customer find(Long id) {
        Customer customer = customerOutputPort.findById(id);
        if (customer == null) throw new EntityNotFoundException(String.format("Customer com id '%s' não encontrado", id));

        return customer;
    }
    
}
