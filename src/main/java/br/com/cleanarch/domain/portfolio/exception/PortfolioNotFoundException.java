package br.com.cleanarch.domain.portfolio.exception;

import br.com.cleanarch.domain.shared.entity.exception.NotFoundException;

public class PortfolioNotFoundException extends NotFoundException {

    public PortfolioNotFoundException(final String message) {
        super(message);
    }
}
