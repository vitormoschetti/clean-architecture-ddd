package br.com.cleanarch.domain.shared.entity.exception;

public class DomainException extends RuntimeException {

    public DomainException(final String message) {
        super(message);
    }
}
