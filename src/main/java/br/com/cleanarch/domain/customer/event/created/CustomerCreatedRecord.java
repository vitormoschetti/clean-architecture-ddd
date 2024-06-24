package br.com.cleanarch.domain.customer.event.created;

import br.com.cleanarch.domain.shared.event.IRecord;

import java.util.UUID;

public record CustomerCreatedRecord(UUID tenantId) implements IRecord {
}
