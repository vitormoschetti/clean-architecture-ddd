package br.com.cleanarch.domain.portfolio.service;

import br.com.cleanarch.domain.portfolio.entity.Portfolio;
import br.com.cleanarch.domain.portfolio.entity.PortfolioItem;
import br.com.cleanarch.domain.portfolio.exception.PortfolioItemNotFoundException;
import br.com.cleanarch.domain.portfolio.exception.PortfolioNotFoundException;
import br.com.cleanarch.domain.portfolio.repository.IPortfolioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PortfolioService implements IPortfolioService {

    private final IPortfolioRepository repository;
//    private final PortfolioItemBuyDispatcher buyDispatcher;
//    private final PortfolioItemSellDispatcher sellDispatcher;
//    private final PortfolioItemPositionClosedDispatcher positionClosedDispatcher;


    @Override
    public Portfolio create(Long customerId) {
        final var portfolio = new Portfolio(customerId);
        repository.create(portfolio);
        return portfolio;
    }

    @Override
    public void buy(UUID portfolioId, Long assetId, BigDecimal quantity, BigDecimal averagePurchasePrice) {

        final var portfolio = repository.findById(portfolioId);

        if (Objects.isNull(portfolio)) {
            throw new PortfolioNotFoundException("Portfolio not found");
        }

        final var item = portfolio.buy(assetId, quantity, averagePurchasePrice);

        repository.update(portfolio);

//        buyDispatcher.dispatch(
//                new PortfolioItemBuyEvent(
//                        new PortfolioItemBuyRecord(item.getAssetId(), item.getAveragePurchasePrice(),
//                                item.getQuantity(), Instant.now().atOffset(ZoneOffset.UTC).toInstant())));

    }

    @Override
    public void sell(UUID portfolioId, Long assetId, BigDecimal quantity) {

        final var portfolio = repository.findById(portfolioId);

        if (Objects.isNull(portfolio)) {
            throw new PortfolioNotFoundException("Portfolio not found");
        }

        final var item = portfolio.sell(assetId, quantity);

        if (Objects.isNull(item)) {
            throw new PortfolioItemNotFoundException("Item not found");
        }

        repository.update(portfolio);

//        if (item.hasPosition())
//            sellDispatcher.dispatch(
//                    new PortfolioItemSellEvent(
//                            new PortfolioItemSellRecord(item.getAssetId(), item.getAveragePurchasePrice(),
//                                    item.getQuantity(), Instant.now().atOffset(ZoneOffset.UTC).toInstant())));
//
//        else
//            positionClosedDispatcher.dispatch(new PortfolioItemPositionClosedEvent(
//                    new PortfolioItemPositionClosedRecord(item.getAssetId(), Instant.now().atOffset(ZoneOffset.UTC).toInstant())));

    }

    @Override
    public List<PortfolioItem> listItems(UUID portfolioId) {

        final var portfolio = repository.findById(portfolioId);

        return portfolio.listItemsAssetId();
    }

    @Override
    public Optional<PortfolioItem> findItem(UUID portfolioId, Long assetId) {
        final var item = repository.findById(portfolioId).findItem(assetId);

        if (item.isEmpty())
            throw new PortfolioItemNotFoundException("Item not found");

        return item;


    }

    @Override
    public Portfolio findPortfolio(Long customerId) {
        final var portfolio = repository.findByCustomerId(customerId);

        if (Objects.isNull(portfolio))
            throw new PortfolioNotFoundException("Portfolio not found");

        return portfolio;

    }
}
