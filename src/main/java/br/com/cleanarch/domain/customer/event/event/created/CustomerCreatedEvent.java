package br.com.cleanarch.domain.customer.event.event.created;

import br.com.cleanarch.domain.shared.event.IEvent;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class CustomerCreatedEvent implements IEvent<CustomerCreatedRecord> {

    private final String traceId;
    private final CustomerCreatedRecord payload;
    private final Instant instantCreated;
    private final String eventName;

    public CustomerCreatedEvent(final CustomerCreatedRecord payload) {
        this.eventName = this.getClass().getSimpleName().toLowerCase();
        this.traceId = UUID.randomUUID().toString();
        this.instantCreated = Instant.now().atOffset(ZoneOffset.UTC).toInstant();
        this.payload = payload;
    }

    @Override
    public String eventName() {
        return this.eventName;
    }

    @Override
    public String traceId() {
        return this.traceId;
    }

    @Override
    public Instant instantCreated() {
        return this.instantCreated;
    }

    @Override
    public CustomerCreatedRecord payload() {
        return this.payload;
    }
}
