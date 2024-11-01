package com.curso.hexagonal.adapters.out.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "addresses")
@Entity
public class AddressEntity {
    
    private String street;
    private String city;
    private String state;

}
