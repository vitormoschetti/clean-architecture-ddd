package br.com.cleanarch.domain.customer.event.handler;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.shared.event.IEvent;
import br.com.cleanarch.domain.shared.event.IEventHandler;

public class PrintLogWhenCustomerCreatedEventHandler implements IEventHandler<Customer> {

    @Override
    public void handle(final IEvent<Customer> event) {
        System.out.println("TraceId: " + event.traceId() + ". Instant: " + event.instantCreated());
        System.out.println("Esse é o primeiro log do evento: CustomerCreated. " + event.payload());
        System.out.println();
    }
}
