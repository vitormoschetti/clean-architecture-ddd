package br.com.cleanarch.application.customer.usecase.input;

public record CustomerChangeAddressInput(String street, String city, String state, String zipCode) {
}
