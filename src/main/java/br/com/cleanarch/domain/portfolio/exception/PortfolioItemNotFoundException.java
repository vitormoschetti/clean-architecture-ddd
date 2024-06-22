package br.com.cleanarch.domain.portfolio.exception;

import br.com.cleanarch.domain.shared.entity.exception.DomainException;

public class PortfolioItemNotFoundException extends DomainException {

    public PortfolioItemNotFoundException(final String message) {
        super(message);
    }
}
