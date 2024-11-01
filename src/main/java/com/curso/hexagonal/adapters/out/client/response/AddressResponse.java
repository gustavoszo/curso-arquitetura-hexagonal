package com.curso.hexagonal.adapters.out.client.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class AddressResponse {
    
    private String street;
    private String city;
    private String state;

}
