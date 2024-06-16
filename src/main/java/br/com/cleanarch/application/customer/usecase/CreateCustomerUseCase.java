package br.com.cleanarch.application.customer.usecase;

import br.com.cleanarch.application.customer.input.CreateUserInput;
import br.com.cleanarch.application.customer.output.CreateUserOutput;
import br.com.cleanarch.application.shared.usecase.IUseCaseWithParam;
import br.com.cleanarch.domain.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateCustomerUseCase implements IUseCaseWithParam<CreateUserInput, CreateUserOutput> {

    private final CustomerService service;

    @Override
    public CreateUserOutput execute(CreateUserInput param) {

        final var customer = service.create(param.name(), param.street(), param.city(), param.state(), param.zipcode());

        return new CreateUserOutput(customer.getTenantId());
    }
}