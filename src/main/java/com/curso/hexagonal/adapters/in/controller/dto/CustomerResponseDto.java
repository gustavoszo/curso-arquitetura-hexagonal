package com.curso.hexagonal.adapters.in.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerResponseDto {
    
    private Long id;
    private String name;
    private String cpf;
    private AddressResponseDto address;
    private boolean cpfIsValid;


}
