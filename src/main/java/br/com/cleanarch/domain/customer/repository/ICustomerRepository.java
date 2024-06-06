package br.com.cleanarch.domain.customer.repository;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.shared.repository.IGenericRepository;

import java.util.UUID;

public interface ICustomerRepository extends IGenericRepository<Customer> {

    Customer findByTenantId(UUID tenantId);
}
