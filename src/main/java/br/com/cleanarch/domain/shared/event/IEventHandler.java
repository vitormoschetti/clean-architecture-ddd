package br.com.cleanarch.domain.shared.event;

public interface IEventHandler<T> {

    void handle(IEvent<T> event);

}
