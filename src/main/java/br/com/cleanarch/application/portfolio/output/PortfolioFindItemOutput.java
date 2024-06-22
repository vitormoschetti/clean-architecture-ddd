package br.com.cleanarch.application.portfolio.output;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PortfolioFindItemOutput(Long assetId, BigDecimal quantity, BigDecimal avgPrice,
                                      BigDecimal totalInvested, LocalDate firstBuyDate, LocalDate lastChangedDate) {
}
