package br.com.cleanarch.domain.customer.event.created;

import br.com.cleanarch.domain.shared.event.IEvent;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class CustomerCreatedEvent implements IEvent<CustomerCreatedRecord> {

    private final UUID traceId;
    private final CustomerCreatedRecord payload;
    private final Instant instantCreated;
    private final String eventName;

    public CustomerCreatedEvent(UUID tenantId) {
        this.eventName = this.getClass().getSimpleName().toLowerCase();
        this.traceId = UUID.randomUUID();
        this.instantCreated = Instant.now().atOffset(ZoneOffset.UTC).toInstant();
        this.payload = new CustomerCreatedRecord(tenantId);
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
        return this.instantCreated;
    }

    @Override
    public CustomerCreatedRecord payload() {
        return this.payload;
    }
}
