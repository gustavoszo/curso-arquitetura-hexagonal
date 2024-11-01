package com.curso.hexagonal.adapters.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.hexagonal.adapters.out.client.response.AddressResponse;

@FeignClient(name = "FindAddressByZipcodeClient", path = "http://localhost:8082")
public interface FindAddressByZipcodeClient {
    
    @GetMapping("/address/{zipcode}")
    AddressResponse getByZipcode(@PathVariable("zipcode") String zipcode);

}
