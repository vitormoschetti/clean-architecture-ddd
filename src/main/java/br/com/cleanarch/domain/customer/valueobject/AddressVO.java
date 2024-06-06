package br.com.cleanarch.domain.customer.valueobject;

import br.com.cleanarch.domain.shared.entity.BaseEntity;
import br.com.cleanarch.domain.shared.entity.IValueObject;
import br.com.cleanarch.domain.shared.notification.DomainNotification;
import br.com.cleanarch.domain.shared.notification.DomainNotificationError;

import java.util.Objects;

public class AddressVO extends BaseEntity implements IValueObject {

    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;

    public AddressVO(final String street, final String city, final String state, final String zipCode) {
        super(new DomainNotification());
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.validate();
    }

    @Override
    protected void validate() {
        if (Objects.isNull(this.street) || this.street.isBlank())
            this.addMessage(new DomainNotificationError("Street is required", this.getClass().getSimpleName()));
        if (Objects.isNull(this.city) || this.city.isBlank())
            this.addMessage(new DomainNotificationError("City is required", this.getClass().getSimpleName()));
        if (Objects.isNull(this.state) || this.state.isBlank())
            this.addMessage(new DomainNotificationError("State is required", this.getClass().getSimpleName()));
        if (Objects.isNull(this.zipCode) || this.zipCode.isBlank())
            this.addMessage(new DomainNotificationError("ZipCode is required", this.getClass().getSimpleName()));
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "AddressVO{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final AddressVO addressVO)) return false;
        return street.equals(addressVO.street) && city.equals(addressVO.city) && state.equals(addressVO.state) && zipCode.equals(addressVO.zipCode);
    }

}
