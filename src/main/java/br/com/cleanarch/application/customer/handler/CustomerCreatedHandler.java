package br.com.cleanarch.application.customer.handler;

import br.com.cleanarch.application.util.KafkaUtil;
import br.com.cleanarch.domain.customer.event.created.CustomerCreatedDispatcher;
import br.com.cleanarch.domain.customer.event.created.CustomerCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerCreatedHandler implements CustomerCreatedDispatcher {

    @Value("${spring.kafka.template.default-topic}")
    private String topic;

    private final KafkaUtil<UUID, CustomerCreatedEvent> kafkaUtil;

    @Override
    public void dispatch(CustomerCreatedEvent event) {
        log.info("Receive event={} traceId={} createAt={}", event.eventName(), event.traceId(), event.instantCreated());
        log.info("Customer {} created", event.payload().tenantId());

        kafkaUtil.send(event.traceId(), event, topic);
    }
}
