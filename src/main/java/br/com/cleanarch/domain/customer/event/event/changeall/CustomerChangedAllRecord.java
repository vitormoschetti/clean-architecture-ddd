package br.com.cleanarch.domain.customer.event.event.changeall;

import br.com.cleanarch.domain.customer.valueobject.AddressVO;
import br.com.cleanarch.domain.shared.event.IRecord;

import java.util.UUID;

public record CustomerChangedAllRecord(UUID tenantId, String name, AddressVO address) implements IRecord {
}
