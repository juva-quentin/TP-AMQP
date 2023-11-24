package com.quentin.tpamqp;

import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue() {
        return new Queue("Rabbit", true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("RabbitExchange");
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("myRoutingKey");
    }
}
