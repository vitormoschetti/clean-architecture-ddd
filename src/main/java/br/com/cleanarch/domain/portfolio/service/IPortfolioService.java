package br.com.cleanarch.domain.portfolio.service;

import br.com.cleanarch.domain.portfolio.entity.Portfolio;
import br.com.cleanarch.domain.portfolio.entity.PortfolioItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPortfolioService {

    Portfolio create(UUID customerId);

    PortfolioItem buy(UUID portfolioId, Long assetId, BigDecimal quantity, BigDecimal averagePurchasePrice);

    PortfolioItem sell(UUID portfolioId, Long assetId, BigDecimal quantity);

    List<PortfolioItem> listItems(UUID portfolioId);

    Optional<PortfolioItem> findItem(UUID portfolioId, Long assetId);

}
