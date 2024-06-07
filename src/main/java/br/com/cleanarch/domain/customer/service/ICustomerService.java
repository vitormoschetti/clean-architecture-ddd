package br.com.cleanarch.domain.customer.service;

import br.com.cleanarch.domain.customer.entity.Customer;

import java.util.List;

public interface ICustomerService {

    Customer create(final String name, final String street, final String city, final String state, final String zipCode);

    Customer changeAddress(final Long id, final String street, final String city, final String state, final String zipCode);

    Customer findById(final Long id);

    Customer update(final Long id, final String name, final String street,
                    final String state, final String city, final String zipCode);

    List<Customer> findAll();

}
