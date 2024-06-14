package br.com.cleanarch.domain.portfolio.entity;

import br.com.cleanarch.domain.shared.valueobject.AuditTimestamps;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

public class Portfolio {

    private final UUID id;
    private final UUID customerId;
    private final Set<PortfolioItem> portfolioItems;
    private final AuditTimestamps audit;

    public Portfolio(UUID customerId) {
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.audit = new AuditTimestamps();
        this.portfolioItems = new HashSet<>();
    }

    public void buy(Long assetId, BigDecimal quantity, BigDecimal averagePurchasePrice) {
        final var item = this.portfolioItems.stream()
                .filter(portfolioItem -> portfolioItem.getAssetId().equals(assetId))
                .findFirst().orElse(new PortfolioItem(assetId));
        item.buy(quantity, averagePurchasePrice);
        this.portfolioItems.add(item);
        this.audit.updateNow();

    }

    public void sell(Long assetId, BigDecimal quantity) {
        final var item = this.portfolioItems.stream()
                .filter(portfolioItem -> portfolioItem.getAssetId().equals(assetId))
                .findFirst().orElse(null);

        if (Objects.nonNull(item)) {
            item.sell(quantity);
            this.portfolioItems.add(item);
            this.clearPositionsZeroQuantity();
            this.audit.updateNow();
        }
    }

    private void clearPositionsZeroQuantity() {
        this.portfolioItems.removeIf(portfolioItem -> portfolioItem.getQuantity().equals(BigDecimal.ZERO));
    }

    public List<Long> listItemsAssetId() {
        return this.portfolioItems.stream().map(PortfolioItem::getAssetId).toList();
    }

    public Optional<PortfolioItem> getItem(Long assetId) {
        return this.portfolioItems.stream().filter(item -> item.getAssetId().equals(assetId))
                .findFirst();
    }

    public int quantityItems() {
        return portfolioItems.size();
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getCustomerId() {
        return this.customerId;
    }

    public Instant getCreatedAt() {
        return this.audit.getCreatedAt();
    }

    public Instant getUpdatedAt() {
        return this.audit.getUpdatedAt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(id, portfolio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
