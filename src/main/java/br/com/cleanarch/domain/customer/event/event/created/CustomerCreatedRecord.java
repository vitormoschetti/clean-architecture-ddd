package br.com.cleanarch.domain.customer.event.event.created;

import br.com.cleanarch.domain.shared.event.IRecord;

import java.util.UUID;

public record CustomerCreatedRecord(String id, UUID tenantId) implements IRecord {
}
