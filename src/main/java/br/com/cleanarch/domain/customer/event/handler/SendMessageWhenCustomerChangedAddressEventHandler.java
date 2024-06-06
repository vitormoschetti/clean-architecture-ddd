package br.com.cleanarch.domain.customer.event.handler;

import br.com.cleanarch.domain.customer.event.event.changedaddress.CustomerChangedAddressRecord;
import br.com.cleanarch.domain.shared.event.IEvent;
import br.com.cleanarch.domain.shared.event.IEventHandler;

public class SendMessageWhenCustomerChangedAddressEventHandler implements IEventHandler<CustomerChangedAddressRecord> {

    @Override
    public void handle(final IEvent<CustomerChangedAddressRecord> event) {
        System.out.println("TraceId: " + event.traceId() + ". Instant: " + event.instantCreated() + ".");
        System.out.println("Payload: " + event.payload());
        System.out.println();
    }
}
