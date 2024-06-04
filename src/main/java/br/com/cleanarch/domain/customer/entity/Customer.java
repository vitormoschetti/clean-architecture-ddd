package br.com.cleanarch.domain.customer.entity;

import br.com.cleanarch.domain.customer.valueobject.AddressVO;
import br.com.cleanarch.domain.shared.entity.BaseEntity;
import br.com.cleanarch.domain.shared.entity.IAggregateRoot;
import br.com.cleanarch.domain.shared.entity.exception.DomainException;
import br.com.cleanarch.domain.shared.notification.DomainNotification;
import br.com.cleanarch.domain.shared.notification.DomainNotificationError;

import java.util.Objects;

public class Customer extends BaseEntity implements IAggregateRoot {

    private final String id;
    private String name;
    private AddressVO address;
    private Boolean active;
    private Long rewardPoints;

    public Customer(final String id, final String name, final String street, final String city, final String state, final String zipCode) {
        super(new DomainNotification());
        this.id = id;
        this.name = name;
        this.address = new AddressVO(street, city, state, zipCode);
        this.rewardPoints = 0L;
        this.validate();
        this.activate();
    }

    public Customer(final String id, final String name, final String street, final String city, final String state, final String zipCode,
                    final Boolean isActive, final Long rewardPoints) {
        super(new DomainNotification());
        this.id = id;
        this.name = name;
        this.address = new AddressVO(street, city, state, zipCode);
        this.active = isActive;
        this.rewardPoints = rewardPoints;
    }

    private void validate() {
        if (Objects.isNull(this.id) || this.id.isEmpty())
            this.addMessage(new DomainNotificationError("Id is required", this.getClass().getSimpleName()));
        if (Objects.isNull(this.name) || this.name.isEmpty())
            this.addMessage(new DomainNotificationError("Name is required", this.getClass().getSimpleName()));
        if (this.address.hasErrors())
            this.address.getMessages().forEach(this::addMessage);
    }

    public void changeName(final String name) {
        this.name = name;
        this.validate();
    }

    public void changeAll(final String name, final String street, final String state, final String city, final String zipCode) {
        this.changeName(name);
        this.changeAddress(new AddressVO(street, city, state, zipCode));
    }

    public void activate() {
        this.active = Boolean.TRUE;
    }

    public void deactivate() {
        this.active = Boolean.FALSE;
    }

    public void addRewardPoints(final Long points) {
        if (points < 0)
            throw new DomainException("Reward Points must be greater equal zero");

        this.rewardPoints += points;
    }

    public Boolean isActive() {
        return this.active;
    }

    public String getId() {
        return this.id;
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
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final Customer customer)) return false;
        return getId().equals(customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void changeAddress(final AddressVO address) {
        this.address = address;
        this.validate();
    }


}
