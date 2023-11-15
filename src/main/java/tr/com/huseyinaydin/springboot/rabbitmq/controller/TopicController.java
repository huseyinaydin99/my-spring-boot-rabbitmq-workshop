package tr.com.huseyinaydin.springboot.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.huseyinaydin.springboot.rabbitmq.model.QueueObject;

import java.time.LocalDateTime;

//بسم الله الرحمن الرحيم

/**
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, RabbitMQ.
* 
*/

@RestController
public class TopicController
{
    @Autowired
    private AmqpTemplate topicExchange;

    @PostMapping("topic/{key}")
    public ResponseEntity<?> sendMessageWithTopicExchange(@PathVariable String key)
    {
        QueueObject object = new QueueObject("topic", LocalDateTime.now());
        topicExchange.convertAndSend(key, object);

        return ResponseEntity.ok(true);
    }
}
