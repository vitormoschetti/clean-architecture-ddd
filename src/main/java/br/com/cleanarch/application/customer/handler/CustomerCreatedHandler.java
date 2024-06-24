package br.com.cleanarch.application.customer.handler;

import br.com.cleanarch.domain.customer.event.created.CustomerCreatedDispatcher;
import br.com.cleanarch.domain.customer.event.created.CustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerCreatedHandler implements CustomerCreatedDispatcher {

    @Override
    public void dispatch(CustomerCreatedEvent event) {
        log.info("Receive event={} traceId={} createAt={}", event.eventName(), event.traceId(), event.instantCreated());
        log.info("Customer {} created", event.payload().tenantId());
    }
}
