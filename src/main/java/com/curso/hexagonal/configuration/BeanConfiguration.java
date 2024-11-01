package com.curso.hexagonal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.hexagonal.application.core.usecases.customer.CreateCustomerUseCase;
import com.curso.hexagonal.application.core.usecases.customer.DeleteCustomerByIdUseCase;
import com.curso.hexagonal.application.core.usecases.customer.FindCustomerByIdUseCase;
import com.curso.hexagonal.application.core.usecases.customer.UpdateCustomerUseCase;
import com.curso.hexagonal.application.ports.in.CreateCustomerInputPort;
import com.curso.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.curso.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.curso.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.curso.hexagonal.application.ports.out.CustomerOutputPort;
import com.curso.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.curso.hexagonal.application.ports.out.SendCpfValidationOutputPort;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateCustomerInputPort createCustomerInputPort(CustomerOutputPort customerOutputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, SendCpfValidationOutputPort sendCpfValidationOutputPort) {
        return new CreateCustomerUseCase(customerOutputPort, findAddressByZipCodeOutputPort, sendCpfValidationOutputPort);
    }

    @Bean
    public FindCustomerByIdInputPort findCustomerByIdInputPort(CustomerOutputPort customerOutputPort) {
        return new FindCustomerByIdUseCase(customerOutputPort);
    }

    @Bean
    public UpdateCustomerInputPort updateCustomerInputPort(CustomerOutputPort customerOutputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort) {
        return new UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeOutputPort, customerOutputPort);
    }

    @Bean
    public DeleteCustomerByIdInputPort deleteCustomerByIdInputPort(CustomerOutputPort customerOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort) {
        return new DeleteCustomerByIdUseCase(customerOutputPort, findCustomerByIdInputPort);
    }
    
}
