package br.com.cleanarch.domain.customer.service;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.customer.event.dispatcher.CustomerEventDispatcher;
import br.com.cleanarch.domain.customer.repository.ICustomerRepository;
import br.com.cleanarch.domain.customer.valueobject.AddressVO;
import br.com.cleanarch.domain.shared.entity.exception.DomainException;
import br.com.cleanarch.domain.shared.service.IService;

import java.util.List;
import java.util.Objects;

public class CustomerService implements IService {

    private final CustomerEventDispatcher dispatcher;
    private final ICustomerRepository repository;

    public CustomerService(
            final CustomerEventDispatcher dispatcher,
            final ICustomerRepository repository) {
        this.dispatcher = dispatcher;
        this.repository = repository;
    }

    public Customer notifyCreated(final String name, final String street, final String city, final String state, final String zipCode) {

        final var customer = new Customer();
        customer.create(name, street, city, state, zipCode);

        this.repository.create(customer);

//        this.dispatcher.notify(new CustomerCreatedEvent(new CustomerCreatedRecord(customer.getId(), customer.getTenantId())));

        return customer;
    }

    public Customer notifyChangeAddress(final Customer customer, final AddressVO address) {

        customer.changeAddress(address.getStreet(), address.getState(), address.getCity(), address.getZipCode());

        this.repository.update(customer);

//        this.dispatcher.notify(new CustomerChangedAddressEvent(customer));

        return customer;
    }

    public Customer findById(final String id) {
        return this.repository.findById(id);
    }

    public Customer notifyUpdate(final String id, final String name, final String street,
                                 final String state, final String city, final String zipCode) {

        final var customer = this.findById(id);

        if (Objects.isNull(customer))
            throw new DomainException(String.format("Customer with id: %s not found", id));

        customer.changeAll(name, street, state, city, zipCode);

        this.repository.update(customer);

//        this.dispatcher.notify(new CustomerChangedAllEvent(customer));

        return customer;

    }

    public List<Customer> findAll() {
        return this.repository.findAll();
    }
}
