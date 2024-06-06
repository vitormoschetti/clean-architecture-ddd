package br.com.cleanarch.domain.customer.event.event.changedaddress;

import br.com.cleanarch.domain.customer.valueobject.AddressVO;
import br.com.cleanarch.domain.shared.event.IRecord;

import java.util.UUID;

public record CustomerChangedAddressRecord(UUID tenantId, AddressVO addressVO) implements IRecord {
}
