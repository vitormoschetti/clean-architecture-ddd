package br.com.cleanarch.domain.portfolio.entity;

import br.com.cleanarch.domain.portfolio.valueobject.AssetPositionVO;
import br.com.cleanarch.domain.shared.entity.BaseEntity;
import br.com.cleanarch.domain.shared.entity.IAggregate;
import br.com.cleanarch.domain.shared.notification.DomainNotification;
import br.com.cleanarch.domain.shared.valueobject.AuditTimestamps;

import java.math.BigDecimal;

public class PortfolioItem extends BaseEntity implements IAggregate {

    private final Long assetId;
    private AssetPositionVO position;
    private final AuditTimestamps audit;

    protected PortfolioItem(Long assetId) {
        super(new DomainNotification());
        this.assetId = assetId;
        this.audit = new AuditTimestamps();
        this.position = new AssetPositionVO();
    }


    public void buy(BigDecimal quantity, BigDecimal averagePurchasePrice) {
        this.position.buy(quantity, averagePurchasePrice);
        this.audit.updateNow();
        this.validate();
    }

    public void sell(BigDecimal quantity) {
        this.position.sell(quantity);
        this.audit.updateNow();
        this.validate();
    }


    @Override
    protected void validate() {
        if (this.position.hasErrors()) {
            this.position.getMessages().forEach(this::addMessage);
        }
    }
}
