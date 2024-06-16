package br.com.cleanarch.application.customer.output;

import br.com.cleanarch.application.shared.output.IOutput;

import java.util.UUID;

public record CreateUserOutput(UUID tenantId) implements IOutput {
}
