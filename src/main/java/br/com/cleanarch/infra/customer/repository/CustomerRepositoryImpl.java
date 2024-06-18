package br.com.cleanarch.infra.customer.repository;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.customer.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {


    @Override
    public Customer findByTenantId(UUID tenantId) {
        return null;
    }

    @Override
    public void create(Customer entity) {

    }

    @Override
    public void update(Customer entity) {

    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
