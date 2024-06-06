package br.com.cleanarch.domain.customer.entity;

import br.com.cleanarch.domain.customer.valueobject.AddressVO;
import br.com.cleanarch.domain.shared.entity.BaseEntity;
import br.com.cleanarch.domain.shared.entity.IAggregateRoot;
import br.com.cleanarch.domain.shared.notification.DomainNotification;
import br.com.cleanarch.domain.shared.notification.DomainNotificationError;

import java.util.Objects;
import java.util.UUID;

public class Customer extends BaseEntity implements IAggregateRoot {

    private String id;
    private UUID tenantId;
    private String name;
    private AddressVO address;
    private Boolean active;
    private Long rewardPoints;

    public Customer() {
        super(new DomainNotification());
    }

    public void create(final String name, final String street, final String city, final String state, final String zipCode) {
        this.tenantId = UUID.randomUUID();
        this.name = name;
        this.address = new AddressVO(street, city, state, zipCode);
        this.rewardPoints = 0L;
        this.activate();
        this.validate();
    }

    public void changeName(final String name) {
        this.name = name;
        this.validate();
    }

    public void changeAddress(final String street, final String state, final String city, final String zipCode) {
        this.address = new AddressVO(street, city, state, zipCode);
        this.validate();
    }

    public void changeAll(final String name, final String street, final String state, final String city, final String zipCode) {
        this.changeName(name);
        this.changeAddress(street, state, city, zipCode);
    }

    public void activate() {
        this.active = Boolean.TRUE;
    }

    public void deactivate() {
        this.active = Boolean.FALSE;
    }

    public void addRewardPoints(final Long points) {
        if (points < 0)
            this.addMessage(new DomainNotificationError("Reward Points must be greater equal zero", this.getClass().getSimpleName()));

        this.rewardPoints += points;
    }

    @Override
    protected void validate() {
        if (Objects.isNull(this.name) || this.name.isEmpty())
            this.addMessage(new DomainNotificationError("Name is required", this.getClass().getSimpleName()));
        if (this.address.hasErrors())
            this.address.getMessages().forEach(this::addMessage);
    }

    public Boolean isActive() {
        return this.active;
    }

    public String getId() {
        return this.id;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public Long getRewardPoints() {
        return rewardPoints;
    }

    public String getName() {
        return this.name;
    }

    public AddressVO getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", active=" + active +
                ", rewardPoints=" + rewardPoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(tenantId, customer.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tenantId);
    }
}
