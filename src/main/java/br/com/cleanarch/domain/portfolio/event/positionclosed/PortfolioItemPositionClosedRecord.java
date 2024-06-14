package br.com.cleanarch.domain.portfolio.event.positionclosed;

import br.com.cleanarch.domain.shared.event.IRecord;

import java.time.Instant;

public record PortfolioItemPositionClosedRecord(Long assetId, Instant sellAt)
        implements IRecord {
}
