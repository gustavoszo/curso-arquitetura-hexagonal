package com.curso.hexagonal.application.core.domain;

public class Customer {

    private Long id;
    private String name;
    private String cpf;
    private Address address;
    private boolean isValidCpf;

    public Customer(){
        this.isValidCpf = false;
    }

    public Customer(Long id, String name, String cpf, Address address, boolean isValidCpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.isValidCpf = isValidCpf;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isValidCpf() {
        return isValidCpf;
    }
    public void setValidCpf(boolean isValidCpf) {
        this.isValidCpf = isValidCpf;
    }

    
    
}