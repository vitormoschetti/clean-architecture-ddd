package br.com.cleanarch.domain.customer.event.dispatcher;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.shared.event.IEvent;
import br.com.cleanarch.domain.shared.event.IEventDispatcher;
import br.com.cleanarch.domain.shared.event.IEventHandler;

import java.util.*;

public class CustomerEventDispatcher implements IEventDispatcher<Customer> {

    private final Map<String, List<IEventHandler<Customer>>> eventHandlers;

    public CustomerEventDispatcher() {
        this.eventHandlers = new HashMap<>();
    }

    @Override
    public void notify(final IEvent<Customer> event) {
        this.eventHandlers.values().stream()
                .flatMap(Collection::stream)
                .toList()
                .forEach(e -> e.handle(event));

    }

    @Override
    public void register(final String eventName, final IEventHandler<Customer> handler) {
        if (!this.eventHandlers.containsKey(eventName)) {
            final var handlers = new ArrayList<IEventHandler<Customer>>();
            handlers.add(handler);
            this.eventHandlers.put(eventName, handlers);

        } else {
            this.eventHandlers.get(eventName).add(handler);
        }
    }

    @Override
    public void unregister(final String eventName, final IEventHandler<Customer> handler) {
        if (this.eventHandlers.containsKey(eventName)) {
            this.eventHandlers.get(eventName).remove(handler);
            if (this.eventHandlers.get(eventName).isEmpty())
                this.eventHandlers.remove(eventName);
        }

    }

    @Override
    public void unregisterAll() {
        this.eventHandlers.clear();
    }

    @Override
    public List<IEventHandler<Customer>> getEventHandlers(final String eventName) {
        if (this.eventHandlers.containsKey(eventName))
            return this.eventHandlers.get(eventName);
        return List.of();
    }

    @Override
    public Boolean containsEvent(final String eventName) {
        return this.eventHandlers.containsKey(eventName);
    }
}
