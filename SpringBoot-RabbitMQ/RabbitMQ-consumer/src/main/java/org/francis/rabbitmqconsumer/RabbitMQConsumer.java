package org.francis.rabbitmqconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Franc1s
 * @date 2022/1/3
 * @apiNote
 */
@Service
public class RabbitMQConsumer {
    private static final Logger logger= LoggerFactory.getLogger(RabbitMQConsumer.class);
    @RabbitListener(queues = {"test.direct.queue"})
    public void receiveMsg(@Payload String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        User user = new ObjectMapper().readValue(message, User.class);
        logger.info(user.toString());
        channel.basicAck(tag,false);
    }
}
