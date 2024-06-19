package br.com.cleanarch.application.customer.input;

public record CreateUserInput(String name, String street, String city, String state, String zipcode) {
}
