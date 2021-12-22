package com.github.pedroluiznogueira.microservices.messagingconsumer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class RabbitMQQueueConfig {

    @Bean
    Queue firstQueue() {
        return new Queue("FirstQueue", false);
    }
}
