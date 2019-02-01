package com.cloudeye.msg.queue;

import com.cloudeye.base.http.Result;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lafangyuan on 2019/1/29.
 */
@RestController
@RequestMapping("/msg/queue/manager")
public class QueueManager {



    @RequestMapping("/count")
    public Result count(String queueName) throws IOException, TimeoutException {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setUsername("aoms");
        factory.setPassword("aoms");
        factory.setVirtualHost("/aoms");
        factory.setHost("10.254.0.117");
        factory.setPort(5672);
        Channel channel = factory.createConnection().createChannel(false);
        long count  = channel.messageCount(queueName);
        return new Result().success(count);
    }
}
