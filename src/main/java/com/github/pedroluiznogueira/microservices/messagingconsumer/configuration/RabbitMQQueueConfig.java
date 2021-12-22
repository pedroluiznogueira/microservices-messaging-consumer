package com.github.pedroluiznogueira.microservices.messagingconsumer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfig {

    // simple way of creating queues
    @Bean
    Queue firstQueue() {
        return new Queue("FirstQueue", false);
    }

    // creating queue with queue builder
    @Bean
    Queue secondQueue() {
        return QueueBuilder
                .durable("SecondQueue")
                .autoDelete()
                .exclusive()
                .build();
    }

}
