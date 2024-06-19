package br.com.cleanarch.infra.customer.repository;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.customer.repository.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class CustomerRepositoryImpl implements ICustomerRepository {

    private final CustomerPostgresRepository repository;

    @Override
    public Customer findByTenantId(UUID tenantId) {
        final var entity = repository.findByTenantId(tenantId);
        return null;
    }

    @Override
    public void create(Customer customer) {
        repository.save(null);
    }

    @Override
    public void update(Customer entity) {
        repository.save(null);
    }

    @Override
    public Customer findById(Long id) {
        final var entity = repository.findById(id);
        return null;
    }

    @Override
    public List<Customer> findAll() {

        final var entities = repository.findAll();

        return List.of();
    }
}
