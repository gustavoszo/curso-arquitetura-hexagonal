package com.curso.hexagonal.adapters.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.curso.hexagonal.application.ports.out.SendCpfValidationOutputPort;

@Component
public class SendCpfValidationAdapter implements SendCpfValidationOutputPort {

    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
    
}
