package com.pp.mensageria;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Queue filaExemplo() {
        return new Queue("fila-pedidos", true);
    }
}
