package br.com.cleanarch.domain.customer.exception;

import br.com.cleanarch.domain.shared.entity.exception.DomainException;

public class CustomerNotFoundException extends DomainException {

    public CustomerNotFoundException(final String message) {
        super(message);
    }
}
