package com.curso.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CustomerMessage {

    private Long id;
    private String name;
    private String cpf;
    private String zipcode;
    private boolean cpfIsValid;
    
}
