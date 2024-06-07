package br.com.cleanarch.domain.customer.service;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.customer.repository.ICustomerRepository;
import br.com.cleanarch.domain.shared.entity.exception.DomainException;

import java.util.List;
import java.util.Objects;

public class CustomerService implements ICustomerService {

    private final ICustomerRepository repository;

    public CustomerService(final ICustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer notifyCreated(final String name, final String street, final String city, final String state, final String zipCode) {

        final var customer = new Customer();
        customer.create(name, street, city, state, zipCode);

        this.repository.create(customer);

        return customer;
    }

    @Override
    public Customer notifyChangeAddress(final Long id, final String street, final String city, final String state, final String zipCode) {

        final var customer = this.repository.findById(id);

        customer.changeAddress(street, state, city, zipCode);

        this.repository.update(customer);

        return customer;
    }

    @Override
    public Customer findById(final Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Customer notifyUpdate(final Long id, final String name, final String street,
                                 final String state, final String city, final String zipCode) {

        final var customer = this.findById(id);

        if (Objects.isNull(customer))
            throw new DomainException(String.format("Customer with id: %s not found", id));

        customer.changeAll(name, street, state, city, zipCode);

        this.repository.update(customer);

        return customer;

    }

    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }
}
