package com.github.pedroluiznogueira.microservices.messagingconsumer.configuration;

import com.github.pedroluiznogueira.microservices.messagingconsumer.rabbitmq.RabbitMQMessageListener;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
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

    @Bean
    Exchange myExchange() {
        return ExchangeBuilder
                .topicExchange("MyExchange")
                .durable(true)
                .build();
    }

    // connection to the queue
    @Bean
    ConnectionFactory connectionFactory() {
        // stable and resilient connection
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");

        return cachingConnectionFactory;
    }

    // bind the queue(s), connection and listener class
    @Bean
    MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMQMessageListener());

        return simpleMessageListenerContainer;
    }
}
