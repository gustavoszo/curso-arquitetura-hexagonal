package com.curso.hexagonal.adapters.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.curso.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.curso.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.curso.hexagonal.application.core.domain.Customer;
import com.curso.hexagonal.application.ports.in.UpdateCustomerInputPort;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "curso")
    public void receive(CustomerMessage customerMessage) {
        Customer customer = CustomerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer.getId(), customer, customerMessage.getZipcode());
    }
    
}
