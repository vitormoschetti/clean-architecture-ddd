package br.com.cleanarch.domain.portfolio.event.buy;

import br.com.cleanarch.domain.shared.event.IEvent;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class PortfolioItemBuyEvent implements IEvent<PortfolioItemBuyRecord> {

    private final String eventName;
    private final UUID traceId;
    private final Instant created;
    private final PortfolioItemBuyRecord payload;

    public PortfolioItemBuyEvent(PortfolioItemBuyRecord payload) {
        this.eventName = this.getClass().getSimpleName();
        this.traceId = UUID.randomUUID();
        this.created = Instant.now().atOffset(ZoneOffset.UTC).toInstant();
        this.payload = payload;
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
    public PortfolioItemBuyRecord payload() {
        return this.payload;
    }
}
