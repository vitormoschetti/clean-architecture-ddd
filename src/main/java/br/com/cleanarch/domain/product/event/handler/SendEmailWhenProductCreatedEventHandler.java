package br.com.cleanarch.domain.product.event.handler;//package br.com.ddd.domain.product.event.handler;
//
//import br.com.ddd.domain.shared.event.IEvent;
//import br.com.ddd.domain.shared.event.IEventHandler;
//import br.com.ddd.domain.product.entity.Product;
//
//public class SendEmailWhenProductCreatedEventHandler implements IEventHandler<Product> {
//
//    @Override
//    public void handle(final IEvent<Product> event) {
//        System.out.println("TraceId: " + event.traceId() + "\nSending email to " + event.payload() + " at " + event.instantCreated());
//        System.out.println();
//    }
//}
