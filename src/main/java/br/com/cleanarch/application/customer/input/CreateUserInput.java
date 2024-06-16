package br.com.cleanarch.application.customer.input;

import br.com.cleanarch.application.shared.input.IInput;

public record CreateUserInput(String name, String street, String city, String state, String zipcode) implements IInput {
}
