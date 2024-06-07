package br.com.cleanarch.cleanarchitectureddd.domain.customer.valueobject;

import br.com.cleanarch.domain.customer.valueobject.AddressVO;
import br.com.cleanarch.domain.shared.notification.DomainNotificationError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressTest {

    @Test
    @DisplayName("should throw domain exception when street is empty")
    public void shouldThrowDomainExceptionWhenStreetEmpty() {

        final var addressVOEmpty = new AddressVO("", "", "", "");
        final var addressVONull = new AddressVO(null, null, null, null);

        assertTrue(addressVOEmpty.hasErrors());
        assertEquals(4, addressVOEmpty.getMessages().size());
        assertEquals(Set.of(
                new DomainNotificationError("Street is required", AddressVO.class.getSimpleName()),
                new DomainNotificationError("City is required", AddressVO.class.getSimpleName()),
                new DomainNotificationError("State is required", AddressVO.class.getSimpleName()),
                new DomainNotificationError("ZipCode is required", AddressVO.class.getSimpleName())
        ), addressVOEmpty.getMessages());

        assertTrue(addressVONull.hasErrors());
        assertEquals(4, addressVONull.getMessages().size());
        assertEquals(Set.of(
                new DomainNotificationError("Street is required", AddressVO.class.getSimpleName()),
                new DomainNotificationError("City is required", AddressVO.class.getSimpleName()),
                new DomainNotificationError("State is required", AddressVO.class.getSimpleName()),
                new DomainNotificationError("ZipCode is required", AddressVO.class.getSimpleName())
        ), addressVONull.getMessages());


    }


}
