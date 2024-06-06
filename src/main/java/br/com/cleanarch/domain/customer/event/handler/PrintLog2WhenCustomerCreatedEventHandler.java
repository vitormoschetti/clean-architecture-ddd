package br.com.cleanarch.domain.customer.event.handler;

import br.com.cleanarch.domain.customer.event.event.created.CustomerCreatedRecord;
import br.com.cleanarch.domain.shared.event.IEvent;
import br.com.cleanarch.domain.shared.event.IEventHandler;

public class PrintLog2WhenCustomerCreatedEventHandler implements IEventHandler<CustomerCreatedRecord> {

    @Override
    public void handle(final IEvent<CustomerCreatedRecord> event) {
        System.out.println("TraceId: " + event.traceId() + ". Instant: " + event.instantCreated());
        System.out.println("Esse é o segundo log do evento: CustomerCreated. " + event.payload());
        System.out.println();
    }
}
