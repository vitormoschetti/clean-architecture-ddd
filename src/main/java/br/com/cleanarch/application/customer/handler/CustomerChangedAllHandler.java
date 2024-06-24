package br.com.cleanarch.application.customer.handler;

import br.com.cleanarch.domain.customer.event.changeall.CustomerChangedAllDispatcher;
import br.com.cleanarch.domain.customer.event.changeall.CustomerChangedAllEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerChangedAllHandler implements CustomerChangedAllDispatcher {

    @Override
    public void dispatch(CustomerChangedAllEvent event) {
        log.info("Receive event={} traceId={} createAt={}", event.eventName(), event.traceId(), event.instantCreated());
        log.info("Customer {} changed all", event.payload().tenantId());
    }
}
