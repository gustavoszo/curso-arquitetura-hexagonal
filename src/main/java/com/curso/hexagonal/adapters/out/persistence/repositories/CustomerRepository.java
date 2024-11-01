package com.curso.hexagonal.adapters.out.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.hexagonal.adapters.out.persistence.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    
}
