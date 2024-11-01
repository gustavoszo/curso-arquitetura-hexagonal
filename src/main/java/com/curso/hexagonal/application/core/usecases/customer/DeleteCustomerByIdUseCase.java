package com.curso.hexagonal.application.core.usecases.customer;

import com.curso.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.curso.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.curso.hexagonal.application.ports.out.CustomerOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private FindCustomerByIdInputPort findCustomerByIdInputPort;
    private CustomerOutputPort customerOutputPort;

    public DeleteCustomerByIdUseCase(CustomerOutputPort customerOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort) {
        this.customerOutputPort = customerOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    @Override
    public void delete(Long id) {
        findCustomerByIdInputPort.find(id);
        customerOutputPort.deleteById(id);
    }
    
}
