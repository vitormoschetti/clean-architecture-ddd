package br.com.cleanarch.domain.portfolio.exception;

import br.com.cleanarch.domain.shared.entity.exception.NotFoundException;

public class PortfolioItemNotFoundException extends NotFoundException {

    public PortfolioItemNotFoundException(final String message) {
        super(message);
    }
}
