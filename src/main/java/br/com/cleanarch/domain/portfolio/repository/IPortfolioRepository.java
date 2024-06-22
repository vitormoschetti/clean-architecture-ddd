package br.com.cleanarch.domain.portfolio.repository;

import br.com.cleanarch.domain.portfolio.entity.Portfolio;
import br.com.cleanarch.domain.shared.repository.IGenericRepository;

import java.util.UUID;

public interface IPortfolioRepository extends IGenericRepository<Portfolio, UUID> {
    Portfolio findByCustomerId(Long customerId);
}
