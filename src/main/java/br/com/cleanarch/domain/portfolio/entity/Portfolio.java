package br.com.cleanarch.domain.portfolio.entity;

import br.com.cleanarch.domain.shared.valueobject.AuditTimestamps;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Portfolio {

    private String id;
    private final UUID customerId;
    private final Set<PortfolioItem> portfolioItems;
    private final AuditTimestamps audit;

    public Portfolio(UUID customerId) {
        this.customerId = customerId;
        this.audit = new AuditTimestamps();
        this.portfolioItems = new HashSet<>();
    }

    public void buy(Long assetId, BigDecimal quantity, BigDecimal averagePurchasePrice) {
        final var item = this.portfolioItems.stream()
                .filter(portfolioItem -> portfolioItem.getAssetId().equals(assetId))
                .findFirst().orElse(null);

        if (Objects.nonNull(item)) {
            item.buy(quantity, averagePurchasePrice);
            this.audit.updateNow();
        }
    }

    public void sell(Long assetId, BigDecimal quantity) {
        final var item = this.portfolioItems.stream()
                .filter(portfolioItem -> portfolioItem.getAssetId().equals(assetId))
                .findFirst().orElse(null);

        if (Objects.nonNull(item)) {
            item.sell(quantity);
            this.audit.updateNow();
        }
    }

}
