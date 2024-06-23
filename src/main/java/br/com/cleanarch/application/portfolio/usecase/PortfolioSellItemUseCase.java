package br.com.cleanarch.application.portfolio.usecase;

import br.com.cleanarch.application.portfolio.input.PortfolioSellItemInput;
import br.com.cleanarch.application.shared.usecase.IUseCaseWithParam;
import br.com.cleanarch.domain.portfolio.service.IPortfolioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.util.function.Tuple2;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class PortfolioSellItemUseCase implements IUseCaseWithParam<Tuple2<UUID, PortfolioSellItemInput>, Void> {

    private final IPortfolioService portfolioService;

    @Override
    public Void execute(Tuple2<UUID, PortfolioSellItemInput> param) {

        final var portfolioId = param.getT1();
        final var input = param.getT2();

        portfolioService.sell(portfolioId, input.assetId(), input.quantity());

        return null;
    }
}
