package br.com.cleanarch.application.portfolio.output;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PortfolioItemOutput(Long assetId, BigDecimal quantity, BigDecimal avgPrice,
                                  BigDecimal totalInvested, LocalDate firstBuyDate, LocalDate lastChangedDate) {
}
