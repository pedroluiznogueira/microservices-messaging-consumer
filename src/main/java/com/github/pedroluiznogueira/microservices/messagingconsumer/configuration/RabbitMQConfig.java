package com.github.pedroluiznogueira.microservices.messagingconsumer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // queue to listen to
    private static final String MyQueue = "MyQueue";

    @Bean
    Queue myQueue() {
        return new Queue(MyQueue, true);
    }

    // connection to the queue


    // bind the queue, connection and listener class
}
