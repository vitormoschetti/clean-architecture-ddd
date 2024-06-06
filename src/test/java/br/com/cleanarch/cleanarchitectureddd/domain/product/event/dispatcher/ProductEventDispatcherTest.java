package br.com.cleanarch.cleanarchitectureddd.domain.product.event.dispatcher;//package br.com.ddd.domain.product.event.dispatcher;
//
//import br.com.ddd.domain.product.entity.Product;
//import br.com.ddd.domain.product.event.event.ProductCreatedEvent;
//import br.com.ddd.domain.product.event.handler.SendEmailWhenProductCreatedEventHandler;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.mockito.Mockito;
//
//import java.math.BigDecimal;
//import java.util.UUID;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//public class ProductEventDispatcherTest {
//
//    @Test
//    @DisplayName("should register an event handler")
//    public void shouldRegisterAnEventHandler() {
//
//        final var eventName = "ProductCreatedEvent";
//
//        final var dispatcher = new ProductEventDispatcher();
//
//        final var handler = new SendEmailWhenProductCreatedEventHandler();
//
//        dispatcher.register(eventName, handler);
//
//        Assertions.assertTrue(dispatcher.containsEvent(eventName));
//        Assertions.assertTrue(dispatcher.getEventHandlers(eventName).contains(handler));
//        Assertions.assertEquals(1, dispatcher.getEventHandlers(eventName).size());
//
//
//    }
//
//    @Test
//    @DisplayName("should unregister an event handler")
//    public void shouldUnregisterAnEventHandler() {
//
//        final var eventName = "ProductCreatedEvent";
//
//        final var dispatcher = new ProductEventDispatcher();
//
//        final var handler = new SendEmailWhenProductCreatedEventHandler();
//
//        dispatcher.register(eventName, handler);
//
//        Assertions.assertTrue(dispatcher.containsEvent(eventName));
//        Assertions.assertTrue(dispatcher.getEventHandlers(eventName).contains(handler));
//        Assertions.assertEquals(1, dispatcher.getEventHandlers(eventName).size());
//
//        dispatcher.unregister(eventName, handler);
//
//        Assertions.assertFalse(dispatcher.containsEvent(eventName));
//        Assertions.assertFalse(dispatcher.getEventHandlers(eventName).contains(handler));
//        Assertions.assertEquals(0, dispatcher.getEventHandlers(eventName).size());
//
//
//    }
//
//    @Test
//    @DisplayName("should unregister all event handler")
//    public void shouldUnregisterAllEventHandler() {
//
//        final var eventName = "ProductCreatedEvent";
//        final var eventName2 = "ProductCreatedEvent2";
//
//        final var dispatcher = new ProductEventDispatcher();
//
//        final var handler = new SendEmailWhenProductCreatedEventHandler();
//
//        dispatcher.register(eventName, handler);
//        dispatcher.register(eventName, handler);
//        dispatcher.register(eventName2, handler);
//        dispatcher.register(eventName2, handler);
//
//        Assertions.assertTrue(dispatcher.containsEvent(eventName));
//        Assertions.assertTrue(dispatcher.containsEvent(eventName2));
//        Assertions.assertTrue(dispatcher.getEventHandlers(eventName).contains(handler));
//        Assertions.assertTrue(dispatcher.getEventHandlers(eventName2).contains(handler));
//        Assertions.assertEquals(2, dispatcher.getEventHandlers(eventName).size());
//        Assertions.assertEquals(2, dispatcher.getEventHandlers(eventName2).size());
//
//        dispatcher.unregisterAll();
//
//        Assertions.assertFalse(dispatcher.containsEvent(eventName));
//        Assertions.assertFalse(dispatcher.getEventHandlers(eventName).contains(handler));
//        Assertions.assertEquals(0, dispatcher.getEventHandlers(eventName).size());
//
//
//    }
//
//    @Test
//    @DisplayName("should notify all event handler")
//    public void shouldNotifyAllEventHandler() {
//
//        final var eventName = "ProductCreatedEvent";
//
//        final var dispatcher = new ProductEventDispatcher();
//
//        final var handler = Mockito.spy(new SendEmailWhenProductCreatedEventHandler());
//
//        dispatcher.register(eventName, handler);
//
//        Assertions.assertTrue(dispatcher.containsEvent(eventName));
//        Assertions.assertTrue(dispatcher.getEventHandlers(eventName).contains(handler));
//        Assertions.assertEquals(1, dispatcher.getEventHandlers(eventName).size());
//
//        final var event = new ProductCreatedEvent(new Product(UUID.randomUUID().toString(), "product-test-notify", new BigDecimal("10.0")));
//
//        dispatcher.notify(event);
//
//        verify(handler, times(1)).handle(event);
//
//
//    }
//
//}
