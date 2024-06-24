package br.com.cleanarch.application.customer.handler;

import br.com.cleanarch.domain.customer.event.changedaddress.CustomerChangedAddressDispatcher;
import br.com.cleanarch.domain.customer.event.changedaddress.CustomerChangedAddressEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerChangedAddressHandler implements CustomerChangedAddressDispatcher {

    @Override
    public void dispatch(CustomerChangedAddressEvent event) {
        log.info("Receive event={} traceId={} createAt={}", event.eventName(), event.traceId(), event.instantCreated());
        log.info("Customer {} changed address", event.payload().tenantId());
    }
}
