package br.com.cleanarch.domain.portfolio.event.sell;

import br.com.cleanarch.domain.shared.event.IRecord;

import java.math.BigDecimal;
import java.time.Instant;

public record PortfolioItemSellRecord(Long assetId, BigDecimal price, BigDecimal quantity, Instant sellAt)
        implements IRecord {
}
