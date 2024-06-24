package br.com.cleanarch.application.portfolio.handler;

import br.com.cleanarch.domain.portfolio.event.buy.PortfolioItemBuyDispatcher;
import br.com.cleanarch.domain.portfolio.event.buy.PortfolioItemBuyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PortfolioItemBuyHandler implements PortfolioItemBuyDispatcher {

    @Override
    public void dispatch(PortfolioItemBuyEvent event) {
        log.info("Receive event={} traceId={} createAt={}", event.eventName(), event.traceId(), event.instantCreated());
        log.info("Portfolio item {} buy", event.payload());
    }
}
