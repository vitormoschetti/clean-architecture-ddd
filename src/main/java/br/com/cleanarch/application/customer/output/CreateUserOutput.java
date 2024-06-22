package br.com.cleanarch.application.customer.output;


import java.util.UUID;

public record CreateUserOutput(UUID tenantId, UUID portfolioId) {
}
