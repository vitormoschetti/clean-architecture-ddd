package br.com.cleanarch.application.portfolio.handler;

import br.com.cleanarch.domain.portfolio.event.sell.PortfolioItemSellDispatcher;
import br.com.cleanarch.domain.portfolio.event.sell.PortfolioItemSellEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PortfolioItemSellHandler implements PortfolioItemSellDispatcher {
    @Override
    public void dispatch(PortfolioItemSellEvent event) {
        log.info("Receive event={} traceId={} createAt={}", event.eventName(), event.traceId(), event.instantCreated());
        log.info("Portfolio item {} sell", event.payload());
    }
}
