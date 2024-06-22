package br.com.cleanarch.domain.portfolio.service;

import br.com.cleanarch.domain.portfolio.entity.Portfolio;
import br.com.cleanarch.domain.portfolio.entity.PortfolioItem;
import br.com.cleanarch.domain.portfolio.event.buy.PortfolioItemBuyDispatcher;
import br.com.cleanarch.domain.portfolio.event.buy.PortfolioItemBuyEvent;
import br.com.cleanarch.domain.portfolio.event.buy.PortfolioItemBuyRecord;
import br.com.cleanarch.domain.portfolio.event.positionclosed.PortfolioItemPositionClosedDispatcher;
import br.com.cleanarch.domain.portfolio.event.positionclosed.PortfolioItemPositionClosedEvent;
import br.com.cleanarch.domain.portfolio.event.positionclosed.PortfolioItemPositionClosedRecord;
import br.com.cleanarch.domain.portfolio.event.sell.PortfolioItemSellDispatcher;
import br.com.cleanarch.domain.portfolio.event.sell.PortfolioItemSellEvent;
import br.com.cleanarch.domain.portfolio.event.sell.PortfolioItemSellRecord;
import br.com.cleanarch.domain.portfolio.exception.PortfolioItemNotFoundException;
import br.com.cleanarch.domain.portfolio.exception.PortfolioNotFoundException;
import br.com.cleanarch.domain.portfolio.repository.IPortfolioRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class PortfolioService implements IPortfolioService {

    private final IPortfolioRepository repository;
    private final PortfolioItemBuyDispatcher buyDispatcher;
    private final PortfolioItemSellDispatcher sellDispatcher;
    private final PortfolioItemPositionClosedDispatcher positionClosedDispatcher;

    public PortfolioService(IPortfolioRepository repository,
                            PortfolioItemBuyDispatcher buyDispatcher,
                            PortfolioItemSellDispatcher sellDispatcher,
                            PortfolioItemPositionClosedDispatcher positionClosedDispatcher) {
        this.repository = repository;
        this.buyDispatcher = buyDispatcher;
        this.sellDispatcher = sellDispatcher;
        this.positionClosedDispatcher = positionClosedDispatcher;
    }

    @Override
    public Portfolio create(Long customerId) {
        final var portfolio = new Portfolio(customerId);
        repository.create(portfolio);
        return portfolio;
    }

    @Override
    public PortfolioItem buy(UUID portfolioId, Long assetId, BigDecimal quantity, BigDecimal averagePurchasePrice) {

        final var portfolio = repository.findById(portfolioId);

        if (Objects.isNull(portfolio)) {
            throw new PortfolioNotFoundException("Portfolio not found");
        }

        final var item = portfolio.buy(assetId, quantity, averagePurchasePrice);

        repository.update(portfolio);

        buyDispatcher.dispatch(
                new PortfolioItemBuyEvent(
                        new PortfolioItemBuyRecord(item.getAssetId(), item.getAveragePurchasePrice(),
                                item.getQuantity(), Instant.now().atOffset(ZoneOffset.UTC).toInstant())));

        return item;
    }

    @Override
    public PortfolioItem sell(UUID portfolioId, Long assetId, BigDecimal quantity) {

        final var portfolio = repository.findById(portfolioId);

        if (Objects.isNull(portfolio)) {
            throw new PortfolioNotFoundException("Portfolio not found");
        }

        final var item = portfolio.sell(assetId, quantity);

        if (Objects.isNull(item)) {
            throw new PortfolioItemNotFoundException("Item not found");
        }

        repository.update(portfolio);

        if (item.hasPosition())
            sellDispatcher.dispatch(
                    new PortfolioItemSellEvent(
                            new PortfolioItemSellRecord(item.getAssetId(), item.getAveragePurchasePrice(),
                                    item.getQuantity(), Instant.now().atOffset(ZoneOffset.UTC).toInstant())));

        else
            positionClosedDispatcher.dispatch(new PortfolioItemPositionClosedEvent(
                    new PortfolioItemPositionClosedRecord(item.getAssetId(), Instant.now().atOffset(ZoneOffset.UTC).toInstant())));

        return item;

    }

    @Override
    public List<PortfolioItem> listItems(UUID portfolioId) {

        final var portfolio = repository.findById(portfolioId);

        return portfolio.listItemsAssetId();
    }

    @Override
    public Optional<PortfolioItem> findItem(UUID portfolioId, Long assetId) {
        return repository.findById(portfolioId).findItem(assetId);
    }
}
