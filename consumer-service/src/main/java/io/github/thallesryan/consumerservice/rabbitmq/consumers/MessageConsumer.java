package io.github.thallesryan.consumerservice.rabbitmq.consumers;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MessageConsumer {

    @RabbitListener(queues = {"product.log"})
    public void consumer(String message){
        log.info("Consumer received a message: " + message);
    }

    @RabbitListener(queues = {"product.log"})
    public void consumerPdf(String message){
        log.info("Generating pdf with the message: " + message);
    }

    @RabbitListener(queues = {"product.log"})
    public void sendEmail(String emailClient){
        log.info("Sending an email to " + emailClient);
    }
}
