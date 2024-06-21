package br.com.cleanarch.application.internal;

import br.com.cleanarch.application.customer.output.CustomerFindAllOutput;
import br.com.cleanarch.application.customer.usecase.CustomerFindAllUseCase;
import br.com.cleanarch.application.shared.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/internal/customer")
public class InternalCustomerController {

    private final CustomerFindAllUseCase findAllUseCase;

    @GetMapping
    public ResponseEntity<Response<List<CustomerFindAllOutput>>> findAll() {

        final var response = findAllUseCase.execute();

        return Response.successResponse(HttpStatus.CREATED, response);

    }

}

