package br.com.cleanarch.domain.customer.service;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.customer.exception.CustomerNotFoundException;
import br.com.cleanarch.domain.customer.repository.ICustomerRepository;
import br.com.cleanarch.domain.shared.entity.exception.DomainException;
import br.com.cleanarch.domain.shared.notification.INotificationError;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    //TODO implementar os eventos de customer service

    private final ICustomerRepository repository;

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

        existsCustomer(tenantId, customer);

        customer.changeAddress(street, state, city, zipCode);

        verifyCustomerIsValid(customer);

        this.repository.update(customer);
    }


    @Override
    public Customer findByTenantId(final UUID tenantId) {
        final var customer = this.repository.findByTenantId(tenantId);

        existsCustomer(tenantId, customer);

        return customer;
    }

    @Override
    public Customer update(final UUID tenantId, final String name, final String street,
                           final String state, final String city, final String zipCode) {

        final var customer = this.findByTenantId(tenantId);

        existsCustomer(tenantId, customer);

        customer.changeAll(name, street, state, city, zipCode);

        verifyCustomerIsValid(customer);

        this.repository.update(customer);

        return customer;

    }

    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }

    private void existsCustomer(UUID tenantId, Customer customer) {
        if (Objects.isNull(customer))
            throw new CustomerNotFoundException(String.format("Customer with id: %s not found", tenantId));
    }

    private void verifyCustomerIsValid(Customer customer) {
        if (customer.hasErrors()) {
            throw new DomainException(customer.getMessages().stream().map(INotificationError::message).collect(Collectors.joining(", ")));
        }
    }
}
