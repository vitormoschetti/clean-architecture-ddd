package br.com.cleanarch.domain.customer.exception;

import br.com.cleanarch.domain.shared.entity.exception.NotFoundException;

public class CustomerNotFoundException extends NotFoundException {

    public CustomerNotFoundException(final String message) {
        super(message);
    }
}
