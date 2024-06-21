package br.com.cleanarch.domain.customer.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(final String message) {
        super(message);
    }
}
