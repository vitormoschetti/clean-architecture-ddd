package br.com.cleanarch.application.portfolio.usecase;

import br.com.cleanarch.application.portfolio.output.PortfolioFindPortfolioOutput;
import br.com.cleanarch.application.portfolio.output.PortfolioItemOutput;
import br.com.cleanarch.application.shared.usecase.IUseCaseWithParam;
import br.com.cleanarch.domain.customer.service.ICustomerService;
import br.com.cleanarch.domain.portfolio.service.IPortfolioService;
import br.com.cleanarch.domain.shared.util.InstantUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class PortfolioFindPortfolioUseCase implements IUseCaseWithParam<UUID, PortfolioFindPortfolioOutput> {

    private final ICustomerService customerService;
    private final IPortfolioService portfolioService;


    @Override
    public PortfolioFindPortfolioOutput execute(UUID tenantId) {

        final var customer = customerService.findByTenantId(tenantId);

        final var portfolio = portfolioService.findPortfolio(customer.getId());

        final var items = portfolio.listItemsAssetId();

        final var itemsOutput = items.stream().map(i -> new PortfolioItemOutput(i.getAssetId(), i.getQuantity(), i.getAveragePurchasePrice(), i.totalInvested(),
                InstantUtil.toLocalDate(i.getCreatedAt()), InstantUtil.toLocalDate(i.getUpdatedAt()))).toList();

        return new PortfolioFindPortfolioOutput(portfolio.getId(), portfolio.quantityItems(), itemsOutput, InstantUtil.toLocalDate(portfolio.getCreatedAt()));
    }
}
