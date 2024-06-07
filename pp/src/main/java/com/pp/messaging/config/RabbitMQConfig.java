package com.pp.messaging.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue filaExemplo() {
        return new Queue("queue-requests", true);
    }
}
