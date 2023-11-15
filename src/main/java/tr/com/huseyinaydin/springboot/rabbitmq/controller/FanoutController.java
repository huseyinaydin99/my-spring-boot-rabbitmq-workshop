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
public class FanoutController
{
    @Autowired
    private AmqpTemplate fanoutExchange;

    @PostMapping("fanout")
    public ResponseEntity<?> sendMessageWithFanoutExchange()
    {
        QueueObject object = new QueueObject("fanout", LocalDateTime.now());
        fanoutExchange.convertAndSend(object);

        return ResponseEntity.ok(true);
    }
}
