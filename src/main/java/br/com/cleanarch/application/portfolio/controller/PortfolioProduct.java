package br.com.cleanarch.application.portfolio.controller;

import br.com.cleanarch.application.portfolio.input.PortfolioBuyItemInput;
import br.com.cleanarch.application.portfolio.input.PortfolioSellItemInput;
import br.com.cleanarch.application.portfolio.usecase.*;
import br.com.cleanarch.application.shared.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.util.function.Tuples;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/portfolio")
public class PortfolioProduct {

    private final PortfolioFindItemUseCase findItemUseCase;
    private final PortfolioFindPortfolioUseCase findPortfolioUseCase;
    private final PortfolioListItemsUseCase listItemsUseCase;
    private final PortfolioBuyItemUseCase buyItemUseCase;
    private final PortfolioSellItemUseCase sellItemUseCase;

    @GetMapping
    public void findPortfolio(@RequestHeader("tenantId") UUID tenantId) {

        final var response = findPortfolioUseCase.execute(tenantId);

        Response.successResponse(HttpStatus.OK, response);

    }

    @GetMapping("/item/{assetId}")
    public void findItem(@RequestHeader("portfolioId") UUID portfolioId, @PathVariable("assetId") Long assetId) {

        final var response = findItemUseCase.execute(Tuples.of(portfolioId, assetId));

        Response.successResponse(HttpStatus.OK, response);

    }

    @GetMapping("/items")
    public void findItem(@RequestHeader("portfolioId") UUID portfolioId) {

        final var response = listItemsUseCase.execute(portfolioId);

        Response.successResponse(HttpStatus.OK, response);

    }

    @PostMapping("/buy")
    public void buyItem(@RequestHeader("portfolioId") UUID portfolioId, PortfolioBuyItemInput input) {

        buyItemUseCase.execute(Tuples.of(portfolioId, input));

        Response.successResponse(HttpStatus.CREATED);

    }

    @PostMapping("/sell")
    public void sellItem(@RequestHeader("portfolioId") UUID portfolioId, PortfolioSellItemInput input) {

        sellItemUseCase.execute(Tuples.of(portfolioId, input));

        Response.successResponse(HttpStatus.CREATED);

    }


}
