package br.com.cleanarch.application.customer.usecase.output;

import java.util.UUID;

public record CustomerFindAllOutput(UUID tenantId, boolean status) {
}
