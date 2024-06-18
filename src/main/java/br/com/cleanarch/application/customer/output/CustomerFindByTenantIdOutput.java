package br.com.cleanarch.application.customer.output;

public record CustomerFindByTenantIdOutput(String name, AddressVOOutput address, boolean status,
                                           long rewardPoints) {
}
