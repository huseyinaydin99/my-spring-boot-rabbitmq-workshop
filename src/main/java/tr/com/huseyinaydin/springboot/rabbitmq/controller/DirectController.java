package tr.com.huseyinaydin.springboot.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class DirectController
{
    @Autowired
    private AmqpTemplate directExchange;

    @Value("${rabbitmq.direct.routing-key-1}")
    private String DIRECT_ROUTING_KEY_1;

    @Value("${rabbitmq.direct.routing-key-2}")
    private String DIRECT_ROUTING_KEY_2;

    @PostMapping("direct/{key}")
    public ResponseEntity<?> sendMessageWithDirectExchange(@PathVariable int key)
    {
        QueueObject object = new QueueObject("direct", LocalDateTime.now());
        String routingKey = key == 1 ? DIRECT_ROUTING_KEY_1 : DIRECT_ROUTING_KEY_2;

        directExchange.convertAndSend(routingKey, object);

        return ResponseEntity.ok(true);
    }
}
