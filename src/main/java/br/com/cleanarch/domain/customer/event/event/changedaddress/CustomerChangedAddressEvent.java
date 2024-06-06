package br.com.cleanarch.domain.customer.event.event.changedaddress;

import br.com.cleanarch.domain.shared.event.IEvent;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class CustomerChangedAddressEvent implements IEvent<CustomerChangedAddressRecord> {

    private final String eventName;
    private final String traceId;
    private final CustomerChangedAddressRecord payload;
    private final Instant instantCreated;

    public CustomerChangedAddressEvent(final CustomerChangedAddressRecord payload) {
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
    public CustomerChangedAddressRecord payload() {
        return this.payload;
    }
}
