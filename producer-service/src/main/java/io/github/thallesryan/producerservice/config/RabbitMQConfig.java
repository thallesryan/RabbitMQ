package io.github.thallesryan.producerservice.config;

import org.rabbitmq.commons.constants.RabbitMQConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Bean
    public Queue queue() {
        return new Queue(RabbitMQConstants.QUEUE_PRODUCT_LOG.toString(), false, false, false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMQConstants.EXG_NAME_MARKETPLACE.toString(), false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(RabbitMQConstants.RK_PRODUCT_LOG.toString());
    }

}
