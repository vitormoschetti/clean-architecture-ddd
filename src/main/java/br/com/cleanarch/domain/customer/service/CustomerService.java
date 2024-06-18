package br.com.cleanarch.domain.customer.service;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.customer.repository.ICustomerRepository;
import br.com.cleanarch.domain.shared.entity.exception.DomainException;
import br.com.cleanarch.domain.shared.notification.INotificationError;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerService implements ICustomerService {

    //TODO implementar os eventos de customer service

    private final ICustomerRepository repository;

    public CustomerService(final ICustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(final String name, final String street,
                           final String city, final String state,
                           final String zipCode) {

        final var customer = new Customer();
        customer.create(name, street, city, state, zipCode);

        verifyCustomerIsValid(customer);

        this.repository.create(customer);

        return customer;
    }


    @Override
    public void changeAddress(final UUID tenantId, final String street, final String city, final String state, final String zipCode) {

        final var customer = this.repository.findByTenantId(tenantId);

        if (Objects.isNull(customer))
            throw new DomainException(String.format("Customer with id: %s not found", tenantId));

        customer.changeAddress(street, state, city, zipCode);

        verifyCustomerIsValid(customer);

        this.repository.update(customer);
    }

    @Override
    public Customer findByTenantId(final UUID tenantId) {
        return this.repository.findByTenantId(tenantId);
    }

    @Override
    public Customer update(final UUID tenantId, final String name, final String street,
                           final String state, final String city, final String zipCode) {

        final var customer = this.findByTenantId(tenantId);

        if (Objects.isNull(customer))
            throw new DomainException(String.format("Customer with id: %s not found", tenantId));

        customer.changeAll(name, street, state, city, zipCode);

        verifyCustomerIsValid(customer);

        this.repository.update(customer);

        return customer;

    }

    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }

    private static void verifyCustomerIsValid(Customer customer) {
        if (customer.hasErrors()) {
            throw new DomainException(customer.getMessages().stream().map(INotificationError::message).collect(Collectors.joining(", ")));
        }
    }
}
