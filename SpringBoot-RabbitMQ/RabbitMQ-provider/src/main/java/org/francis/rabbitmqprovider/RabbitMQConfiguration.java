package org.francis.rabbitmqprovider;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Franc1s
 * @date 2022/1/3
 * @apiNote
 */
@Configuration
public class RabbitMQConfiguration {
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("test_direct_exchange", true, false);
    }

    @Bean
    public Queue directQueue() {
        return new Queue("test.direct.queue", true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("test");
    }
}
