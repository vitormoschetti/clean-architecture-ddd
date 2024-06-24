package br.com.cleanarch.domain.portfolio.event.sell;

import br.com.cleanarch.domain.shared.event.IEvent;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class PortfolioItemSellEvent implements IEvent<PortfolioItemSellRecord> {

    private final String eventName;
    private final UUID traceId;
    private final Instant created;
    private final PortfolioItemSellRecord payload;

    public PortfolioItemSellEvent(Long assetId, BigDecimal price, BigDecimal quantity, Instant sellAt) {
        this.eventName = this.getClass().getSimpleName();
        this.traceId = UUID.randomUUID();
        this.created = Instant.now().atOffset(ZoneOffset.UTC).toInstant();
        this.payload = new PortfolioItemSellRecord(assetId, price, quantity, sellAt);
    }

    @Override
    public String eventName() {
        return this.eventName;
    }

    @Override
    public UUID traceId() {
        return this.traceId;
    }

    @Override
    public Instant instantCreated() {
        return this.created;
    }

    @Override
    public PortfolioItemSellRecord payload() {
        return this.payload;
    }
}
