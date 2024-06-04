package br.com.cleanarch.domain.product.event.handler;

import br.com.cleanarch.domain.product.entity.Product;
import br.com.cleanarch.domain.shared.event.IEvent;
import br.com.cleanarch.domain.shared.event.IEventHandler;

public class SendEmailWhenProductCreatedEventHandler implements IEventHandler<Product> {

    @Override
    public void handle(final IEvent<Product> event) {
        System.out.println("TraceId: " + event.traceId() + "\nSending email to " + event.payload() + " at " + event.instantCreated());
        System.out.println();
    }
}
