package br.com.cleanarch.domain.shared.event;

public interface IEventHandler<T extends IRecord> {

    void handle(IEvent<T> event);

}
