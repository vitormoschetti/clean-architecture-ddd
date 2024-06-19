package br.com.cleanarch.application.customer.usecase.output;

public record CustomerFindByTenantIdOutput(String name, AddressVOOutput address, boolean status,
                                           long rewardPoints) {
}
