package br.com.cleanarch.domain.product.entity;

import br.com.cleanarch.domain.shared.entity.BaseEntity;
import br.com.cleanarch.domain.shared.entity.IAggregateRoot;
import br.com.cleanarch.domain.shared.entity.exception.DomainException;
import br.com.cleanarch.domain.shared.notification.DomainNotification;
import br.com.cleanarch.domain.shared.valueobject.AuditTimestamps;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Product extends BaseEntity implements IAggregateRoot {

    private Long id;
    private String name;
    private BigDecimal price;
    private final AuditTimestamps audit;


    public Product(String name, BigDecimal price) {
        super(new DomainNotification());
        this.name = name;
        this.price = price;
        this.audit = new AuditTimestamps();
        this.audit.createNow();
    }

    public Product(final Long id, final String name, final BigDecimal price,
                   final Instant createdAt, final Instant updatedAt) {
        super(new DomainNotification());
        this.id = id;
        this.name = name;
        this.price = price;
        this.audit = new AuditTimestamps(createdAt, updatedAt);
        this.validate();
    }

    private void validate() {
        if (Objects.isNull(this.name) || this.name.isBlank())
            throw new DomainException("Name is required");
        if (Objects.isNull(this.price) || this.price.compareTo(BigDecimal.ZERO) <= 0)
            throw new DomainException("Price is required");
        if(Objects.isNull(this.audit))
            throw new DomainException("Audit object is null");
    }

    public void changeName(final String name) {
        this.name = name;
        this.audit.updateNow();
        this.validate();
    }

    public void changePrice(final BigDecimal price) {
        this.price = price;
        this.audit.updateNow();
        this.validate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Instant craetedAt() {
        return audit.getCreatedAt();
    }

    public Instant updatedAt() {
        return audit.getUpdatedAt();
    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
