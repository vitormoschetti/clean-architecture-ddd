package br.com.cleanarch.application.portfolio.input;

import java.math.BigDecimal;

public record PortfolioSellItemInput(Long assetId, BigDecimal quantity) {
}
