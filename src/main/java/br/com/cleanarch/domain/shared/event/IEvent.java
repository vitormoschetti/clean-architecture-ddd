package br.com.cleanarch.domain.shared.event;

import java.time.Instant;
import java.util.UUID;

public interface IEvent<T extends IRecord> {

    String eventName();

    UUID traceId();

    Instant instantCreated();

    T payload();


}
