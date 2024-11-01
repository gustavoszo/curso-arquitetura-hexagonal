package com.curso.hexagonal.application.ports.out;

public interface SendCpfValidationOutputPort {

    void send(String cpf);
    
}
