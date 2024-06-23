package br.com.cleanarch.application.customer.usecase;

import br.com.cleanarch.application.customer.output.CustomerFindAllOutput;
import br.com.cleanarch.application.shared.usecase.IUseCase;
import br.com.cleanarch.domain.customer.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerFindAllUseCase implements IUseCase<List<CustomerFindAllOutput>> {

    private final ICustomerService service;

    @Override
    public List<CustomerFindAllOutput> execute() {

        final var customers = service.findAll();

        return customers.stream().map(c -> new CustomerFindAllOutput(c.getTenantId(), c.isActive())).toList();
    }
}
