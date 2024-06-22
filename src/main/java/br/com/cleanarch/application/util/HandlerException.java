package br.com.cleanarch.application.util;

import br.com.cleanarch.application.shared.response.Response;
import br.com.cleanarch.domain.customer.exception.CustomerNotFoundException;
import br.com.cleanarch.domain.portfolio.exception.PortfolioItemNotFoundException;
import br.com.cleanarch.domain.portfolio.exception.PortfolioNotFoundException;
import br.com.cleanarch.domain.shared.entity.exception.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DomainException.class})
    public ResponseEntity<Response<Void>> handleDomainException(final DomainException ex) {

        final var messages = Arrays.stream(ex.getMessage().split(",")).map(String::trim).toList();

        return Response.failedResponse(HttpStatus.BAD_REQUEST, messages);

    }

    @ExceptionHandler({CustomerNotFoundException.class, PortfolioNotFoundException.class, PortfolioItemNotFoundException.class})
    public ResponseEntity<Response<Void>> handleCustomerNotFoundException(final CustomerNotFoundException ex) {

        final var messages = Arrays.stream(ex.getMessage().split(",")).map(String::trim).toList();

        return Response.failedResponse(HttpStatus.NOT_FOUND, messages);

    }

}