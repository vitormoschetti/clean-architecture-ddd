package br.com.cleanarch.application.customer.controller;

import br.com.cleanarch.application.customer.input.CreateUserInput;
import br.com.cleanarch.application.customer.output.CreateUserOutput;
import br.com.cleanarch.application.customer.usecase.CustomerCreateUseCase;
import br.com.cleanarch.application.shared.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerCreateUseCase createCustomer;

    public CustomerController(CustomerCreateUseCase createCustomer) {
        this.createCustomer = createCustomer;
    }

    @PostMapping
    public Response<CreateUserOutput> save(@RequestBody CreateUserInput input) {

        final var response = createCustomer.execute(input);

        return Response.successResponse(HttpStatus.CREATED, "Customer created", response);

    }

}

