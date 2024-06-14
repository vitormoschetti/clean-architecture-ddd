package br.com.cleanarch.domain.shared.event;

public interface IDispatcher<E extends IEvent> {

    void dispatch(E event);

}
