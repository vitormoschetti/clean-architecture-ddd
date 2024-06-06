package br.com.cleanarch.domain.shared.event;

import java.time.Instant;

public interface IEvent<T extends IRecord> {

    String eventName();

    String traceId();

    Instant instantCreated();

    T payload();


}
