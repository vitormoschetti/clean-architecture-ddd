package br.com.cleanarch.application.customer.usecase;

import br.com.cleanarch.application.customer.input.CustomerUpdateInput;
import br.com.cleanarch.application.shared.usecase.IUseCaseWithParam;
import br.com.cleanarch.domain.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.util.function.Tuple2;

import java.util.UUID;

@Slf4j
@Service
public class CustomerUpdateUseCase implements IUseCaseWithParam<Tuple2<UUID, CustomerUpdateInput>, Void> {

    private final CustomerService customerService;

    public CustomerUpdateUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Void execute(Tuple2<UUID, CustomerUpdateInput> param) {

        final var tenantId = param.getT1();
        final var input = param.getT2();

        customerService.update(tenantId, input.name(), input.street(), input.city(), input.state(), input.zipCode());

        return null;
    }
}
