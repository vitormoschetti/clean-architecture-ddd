package br.com.cleanarch.application.customer.usecase;

import br.com.cleanarch.application.customer.output.AddressVOOutput;
import br.com.cleanarch.application.customer.output.CustomerFindByTenantIdOutput;
import br.com.cleanarch.application.shared.usecase.IUseCaseWithParam;
import br.com.cleanarch.domain.customer.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerFindUseCase implements IUseCaseWithParam<UUID, CustomerFindByTenantIdOutput> {

    private final ICustomerService service;

    @Override
    public CustomerFindByTenantIdOutput execute(UUID tenantId) {

        final var customer = service.findByTenantId(tenantId);

        return new CustomerFindByTenantIdOutput(customer.getName(),
                new AddressVOOutput(customer.getAddress().getStreet(), customer.getAddress().getCity(), customer.getAddress().getState(), customer.getAddress().getZipCode()),
                customer.isActive(), customer.getRewardPoints());
    }
}
