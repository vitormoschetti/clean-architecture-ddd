package br.com.cleanarch.application.customer.usecase;

import br.com.cleanarch.application.customer.input.CreateCustomerInput;
import br.com.cleanarch.application.customer.output.CreateUserOutput;
import br.com.cleanarch.application.shared.usecase.IUseCaseWithParam;
import br.com.cleanarch.domain.customer.service.CustomerService;
import br.com.cleanarch.domain.portfolio.service.PortfolioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerCreateUseCase implements IUseCaseWithParam<CreateCustomerInput, CreateUserOutput> {

    private final CustomerService service;
    private final PortfolioService portfolioService;

    @Override
    public CreateUserOutput execute(CreateCustomerInput param) {

        final var customer = service.create(param.name(), param.street(), param.city(), param.state(), param.zipCode());

        final var portfolio = portfolioService.create(customer.getId());

        return new CreateUserOutput(customer.getTenantId(), portfolio.getId());
    }
}
