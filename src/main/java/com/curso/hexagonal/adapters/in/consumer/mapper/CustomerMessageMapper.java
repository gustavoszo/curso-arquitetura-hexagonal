package com.curso.hexagonal.adapters.in.consumer.mapper;

import com.curso.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.curso.hexagonal.application.core.domain.Customer;

public class CustomerMessageMapper {
    
    public static Customer toCustomer(CustomerMessage customerMessage) {
        return new Customer(customerMessage.getId(), customerMessage.getName(), customerMessage.getCpf(), null, customerMessage.isCpfIsValid());
    }

}
