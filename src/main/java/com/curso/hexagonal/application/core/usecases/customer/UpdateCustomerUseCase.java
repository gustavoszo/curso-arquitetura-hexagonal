package com.curso.hexagonal.application.core.usecases.customer;

import com.curso.hexagonal.application.core.domain.Address;
import com.curso.hexagonal.application.core.domain.Customer;
import com.curso.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.curso.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.curso.hexagonal.application.ports.out.CustomerOutputPort;
import com.curso.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private FindCustomerByIdInputPort findCustomerByIdInputPort;
    private FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private CustomerOutputPort customerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort finfAddressByZipCodeOutputPort, CustomerOutputPort customerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = finfAddressByZipCodeOutputPort;
        this.customerOutputPort = customerOutputPort;
    }

    @Override
    public Customer update(Long id, Customer customer, String zipcode) {
        customer = findCustomerByIdInputPort.find(id);
        Address address = findAddressByZipCodeOutputPort.execute(zipcode);
        customer.setAddress(address);
        customer.setName(customer.getName());
        customer.setCpf(customer.getCpf());
        return customerOutputPort.update(customer);
    }
    
}
