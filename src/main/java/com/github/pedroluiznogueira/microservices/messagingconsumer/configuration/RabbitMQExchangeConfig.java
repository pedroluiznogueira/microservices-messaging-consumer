package com.github.pedroluiznogueira.microservices.messagingconsumer.configuration;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

    // exchanges are interfaces, so we create exchange types
    @Bean
    Exchange myFirstExchange() {
        return new TopicExchange("myFirstExchange");
    }


}
