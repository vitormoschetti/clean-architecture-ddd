package br.com.cleanarch.application.customer.usecase.input;

public record CustomerUpdateInput(String name, String street, String city, String state, String zipCode) {
}
