package br.com.cleanarch.application.customer.input;

public record CreateCustomerInput(String name, String street, String city, String state, String zipCode) {
}
