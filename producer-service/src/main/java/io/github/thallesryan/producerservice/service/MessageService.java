package io.github.thallesryan.producerservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static io.github.thallesryan.producerservice.config.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static io.github.thallesryan.producerservice.config.RabbitMQConfig.RK_PRODUCT_LOG;


@Log4j2
@Service
@RequiredArgsConstructor
public class MessageService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("Received message " + message);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }
}
