package com.curso.hexagonal.adapters.in.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.hexagonal.adapters.in.controller.dto.CustomerRequestDto;
import com.curso.hexagonal.adapters.in.controller.dto.CustomerResponseDto;
import com.curso.hexagonal.adapters.in.controller.dto.mapper.CustomerMapper;
import com.curso.hexagonal.application.core.domain.Customer;
import com.curso.hexagonal.application.ports.in.CreateCustomerInputPort;
import com.curso.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.curso.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.curso.hexagonal.application.ports.in.UpdateCustomerInputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private CreateCustomerInputPort createCustomerInputPort;
    private FindCustomerByIdInputPort findCustomerByIdInputPort;
    private UpdateCustomerInputPort updateCustomerInputPort;
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> create(@Validated @RequestBody CustomerRequestDto customerCreateDto) {
        Customer customer = CustomerMapper.toCustomer(customerCreateDto);
        createCustomerInputPort.create(customer, customerCreateDto.getZipcode());
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerMapper.toCustomerResponseDto(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getById(@PathVariable("id") Long id) {
        Customer customer = findCustomerByIdInputPort.find(id);
        return ResponseEntity.ok(CustomerMapper.toCustomerResponseDto(customer));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> update(@PathVariable("id") Long id, CustomerRequestDto customerRequestDto) {
        Customer customer = updateCustomerInputPort.update(id, CustomerMapper.toCustomer(customerRequestDto), customerRequestDto.getZipcode());
        return ResponseEntity.ok(CustomerMapper.toCustomerResponseDto(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}