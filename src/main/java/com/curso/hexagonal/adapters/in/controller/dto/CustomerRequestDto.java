package com.curso.hexagonal.adapters.in.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerRequestDto {
    
    @NotBlank
    private String name;
    @NotBlank
    private String zipcode;
    @NotBlank
    private String cpf;

}
