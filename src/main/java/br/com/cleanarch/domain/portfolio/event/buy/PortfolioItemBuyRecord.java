package br.com.cleanarch.domain.portfolio.event.buy;

import br.com.cleanarch.domain.shared.event.IRecord;

import java.math.BigDecimal;
import java.time.Instant;

public record PortfolioItemBuyRecord(Long assetId, BigDecimal price, BigDecimal quantity, Instant buyAt)
        implements IRecord {
}
