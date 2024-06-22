package br.com.cleanarch.application.portfolio.usecase;

import br.com.cleanarch.application.portfolio.output.PortfolioFindPortfolioOutput;
import br.com.cleanarch.application.portfolio.output.PortfolioItemOutput;
import br.com.cleanarch.application.shared.usecase.IUseCaseWithParam;
import br.com.cleanarch.domain.portfolio.service.PortfolioService;
import br.com.cleanarch.domain.shared.util.InstantUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PortfolioFindPortfolioUseCase implements IUseCaseWithParam<Long, PortfolioFindPortfolioOutput> {

    private final PortfolioService portfolioService;


    @Override
    public PortfolioFindPortfolioOutput execute(Long customerId) {

        final var portfolio = portfolioService.findPortfolio(customerId);

        final var items = portfolio.listItemsAssetId();

        final var itemsOutput = items.stream().map(i -> new PortfolioItemOutput(i.getAssetId(), i.getQuantity(), i.getAveragePurchasePrice(), i.totalInvested(),
                InstantUtil.toLocalDate(i.getCreatedAt()), InstantUtil.toLocalDate(i.getUpdatedAt()))).toList();

        return new PortfolioFindPortfolioOutput(portfolio.getId(), portfolio.quantityItems(), itemsOutput, InstantUtil.toLocalDate(portfolio.getCreatedAt()));
    }
}
