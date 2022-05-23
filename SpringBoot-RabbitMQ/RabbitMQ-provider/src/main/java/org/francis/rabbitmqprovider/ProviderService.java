package org.francis.rabbitmqprovider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Franc1s
 * @date 2022/1/3
 * @apiNote
 */
@Service
public class ProviderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void confirmCallBack(){
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("cause = " + cause);
            System.out.println("ack = " + ack);
        });
    }

    public void test(String message){
        rabbitTemplate.convertAndSend(RabbitMQConstant.DIRECT_EXCHANGE_NAME,RabbitMQConstant.ROUTING_KEY_NAME,message);
    }

    public void test1(String user){
        rabbitTemplate.convertAndSend(RabbitMQConstant.DIRECT_EXCHANGE_NAME,RabbitMQConstant.ROUTING_KEY_NAME,user);
    }
}
