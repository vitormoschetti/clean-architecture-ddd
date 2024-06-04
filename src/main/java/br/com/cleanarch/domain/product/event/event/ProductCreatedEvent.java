package br.com.cleanarch.domain.product.event.event;

import br.com.cleanarch.domain.product.entity.Product;
import br.com.cleanarch.domain.shared.event.IEvent;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class ProductCreatedEvent implements IEvent<Product> {

    private final String traceId;
    private final Product data;
    private final Instant date;

    @Override
    public String traceId() {
        return this.traceId;
    }

    @Override
    public Instant instantCreated() {
        return this.date;
    }

    @Override
    public Product payload() {
        return this.data;
    }

    public ProductCreatedEvent(final Product data) {
        this.data = data;
        this.traceId = UUID.randomUUID().toString();
        this.date = Instant.now().atOffset(ZoneOffset.UTC).toInstant();
    }


}
