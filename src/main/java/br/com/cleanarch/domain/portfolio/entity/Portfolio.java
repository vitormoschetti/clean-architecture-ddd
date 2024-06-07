package br.com.cleanarch.domain.portfolio.entity;

import br.com.cleanarch.domain.shared.valueobject.AuditTimestamps;

import java.util.Set;
import java.util.UUID;

public class Portfolio {

    private String id;
    private UUID customerId;
    private Set<PortfolioItem> portfolioItems;
    private final AuditTimestamps audit;

    public Portfolio() {
        this.audit = new AuditTimestamps();
    }
}
