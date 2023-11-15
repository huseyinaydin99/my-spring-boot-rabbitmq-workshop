package tr.com.huseyinaydin.springboot.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class DefaultController
{
    @Autowired
    private AmqpTemplate defaultExchange;

    @PostMapping("default")
    public ResponseEntity<?> sendMessageWithDefaultExchange()
    {
        QueueObject object = new QueueObject("default", LocalDateTime.now());

        defaultExchange.convertAndSend(object);

        return ResponseEntity.ok(true);
    }
}
