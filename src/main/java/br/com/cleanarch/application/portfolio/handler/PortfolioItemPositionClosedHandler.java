package br.com.cleanarch.application.portfolio.handler;

import br.com.cleanarch.domain.portfolio.event.positionclosed.PortfolioItemPositionClosedDispatcher;
import br.com.cleanarch.domain.portfolio.event.positionclosed.PortfolioItemPositionClosedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PortfolioItemPositionClosedHandler implements PortfolioItemPositionClosedDispatcher {
    @Override
    public void dispatch(PortfolioItemPositionClosedEvent event) {
        log.info("Receive event={} traceId={} createAt={}", event.eventName(), event.traceId(), event.instantCreated());
        log.info("Portfolio item {} position closed", event.payload());
    }
}
