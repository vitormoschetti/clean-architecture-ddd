package br.com.cleanarch.application.portfolio.input;

import java.math.BigDecimal;

public record PortfolioBuyItemInput(Long assetId, BigDecimal quantity, BigDecimal averagePurchasePrice) {
}
