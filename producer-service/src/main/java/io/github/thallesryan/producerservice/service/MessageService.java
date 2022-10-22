package io.github.thallesryan.producerservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.rabbitmq.commons.constants.RabbitMQConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;



@Log4j2
@Service
@RequiredArgsConstructor
public class MessageService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("Received message " + message);
        rabbitTemplate.convertAndSend(RabbitMQConstants.EXG_NAME_MARKETPLACE.toString(), RabbitMQConstants.RK_PRODUCT_LOG.toString(), message);
    }
}
