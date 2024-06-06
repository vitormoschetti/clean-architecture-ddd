package br.com.cleanarch.domain.product.event.dispatcher;//package br.com.ddd.domain.product.event.dispatcher;
//
//import br.com.ddd.domain.shared.event.IEvent;
//import br.com.ddd.domain.shared.event.IEventDispatcher;
//import br.com.ddd.domain.shared.event.IEventHandler;
//import br.com.ddd.domain.product.entity.Product;
//
//import java.util.*;
//
//public class ProductEventDispatcher implements IEventDispatcher<Product> {
//
//    private final Map<String, List<IEventHandler<Product>>> eventHandlers;
//
//    public ProductEventDispatcher() {
//        this.eventHandlers = new HashMap<>();
//    }
//
//    @Override
//    public void notify(final IEvent<Product> event) {
//        this.eventHandlers.values().stream()
//                .flatMap(Collection::stream)
//                .toList()
//                .forEach(e -> e.handle(event));
//
//    }
//
//    @Override
//    public void register(final String eventName, final IEventHandler<Product> handler) {
//        if (!this.eventHandlers.containsKey(eventName)) {
//            final var handlers = new ArrayList<IEventHandler<Product>>();
//            handlers.add(handler);
//            this.eventHandlers.put(eventName, handlers);
//
//        } else {
//            this.eventHandlers.get(eventName).add(handler);
//        }
//    }
//
//    @Override
//    public void unregister(final String eventName, final IEventHandler<Product> handler) {
//        if (this.eventHandlers.containsKey(eventName)) {
//            this.eventHandlers.get(eventName).remove(handler);
//            if (this.eventHandlers.get(eventName).isEmpty())
//                this.eventHandlers.remove(eventName);
//        }
//
//    }
//
//    @Override
//    public void unregisterAll() {
//        this.eventHandlers.clear();
//    }
//
//    @Override
//    public List<IEventHandler<Product>> getEventHandlers(final String eventName) {
//        if (this.eventHandlers.containsKey(eventName))
//            return this.eventHandlers.get(eventName);
//        return List.of();
//    }
//
//    @Override
//    public Boolean containsEvent(final String eventName) {
//        return this.eventHandlers.containsKey(eventName);
//    }
//}
