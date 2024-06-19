package br.com.cleanarch.infra.customer.repository;

import br.com.cleanarch.infra.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerPostgresRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByTenantId(UUID tenantId);
}
