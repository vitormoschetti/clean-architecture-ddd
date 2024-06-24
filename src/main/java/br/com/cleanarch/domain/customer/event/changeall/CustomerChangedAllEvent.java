package br.com.cleanarch.domain.customer.event.changeall;

import br.com.cleanarch.domain.shared.event.IEvent;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class CustomerChangedAllEvent implements IEvent<CustomerChangedAllRecord> {

    private final String eventName;
    private final UUID traceId;
    private final CustomerChangedAllRecord payload;
    private final Instant instantCreated;

    public CustomerChangedAllEvent(UUID tenantId) {
        this.eventName = this.getClass().getSimpleName().toLowerCase();
        this.traceId = UUID.randomUUID();
        this.instantCreated = Instant.now().atOffset(ZoneOffset.UTC).toInstant();
        this.payload = new CustomerChangedAllRecord(tenantId);
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
    public CustomerChangedAllRecord payload() {
        return this.payload;
    }
}
