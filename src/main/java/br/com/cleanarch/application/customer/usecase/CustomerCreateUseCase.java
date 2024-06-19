package br.com.cleanarch.application.customer.usecase;

import br.com.cleanarch.application.customer.usecase.input.CreateUserInput;
import br.com.cleanarch.application.customer.usecase.output.CreateUserOutput;
import br.com.cleanarch.application.shared.usecase.IUseCaseWithParam;
import br.com.cleanarch.domain.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerCreateUseCase implements IUseCaseWithParam<CreateUserInput, CreateUserOutput> {

    private final CustomerService service;

    public CustomerCreateUseCase(CustomerService service) {
        this.service = service;
    }

    @Override
    public CreateUserOutput execute(CreateUserInput param) {

        final var customer = service.create(param.name(), param.street(), param.city(), param.state(), param.zipcode());

        return new CreateUserOutput(customer.getTenantId());
    }
}
