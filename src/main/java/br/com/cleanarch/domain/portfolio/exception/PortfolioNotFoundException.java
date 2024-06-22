package br.com.cleanarch.domain.portfolio.exception;

import br.com.cleanarch.domain.shared.entity.exception.DomainException;

public class PortfolioNotFoundException extends DomainException {

    public PortfolioNotFoundException(final String message) {
        super(message);
    }
}
