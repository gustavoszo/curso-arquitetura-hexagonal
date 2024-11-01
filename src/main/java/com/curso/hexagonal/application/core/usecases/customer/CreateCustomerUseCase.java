package com.curso.hexagonal.application.core.usecases.customer;

import com.curso.hexagonal.application.core.domain.Customer;
import com.curso.hexagonal.application.ports.in.CreateCustomerInputPort;
import com.curso.hexagonal.application.ports.out.CustomerOutputPort;
import com.curso.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.curso.hexagonal.application.ports.out.SendCpfValidationOutputPort;

public class CreateCustomerUseCase implements CreateCustomerInputPort {
    
    private CustomerOutputPort createCustomerOutputPort;
    private FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private SendCpfValidationOutputPort sendCpfValidationOutputPort;

    public CreateCustomerUseCase(CustomerOutputPort createCustomerOutputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, SendCpfValidationOutputPort sendCpfValidationOutputPort) {
        this.createCustomerOutputPort = createCustomerOutputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.sendCpfValidationOutputPort = sendCpfValidationOutputPort;
    }
    
    @Override
    public void create(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.execute(zipCode);
        customer.setAddress(address);
        createCustomerOutputPort.create(customer);
        sendCpfValidationOutputPort.send(customer.getCpf());
    }

}
