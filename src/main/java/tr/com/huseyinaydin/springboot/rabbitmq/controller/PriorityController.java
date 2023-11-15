package tr.com.huseyinaydin.springboot.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class PriorityController
{
    @Autowired
    private AmqpTemplate defaultPriorityExchange;

    @PostMapping("priority")
    public ResponseEntity<?> sendPriorityMessage(
            @RequestParam(value = "priority", required = false, defaultValue = "0") int priority)
    {
        QueueObject object = new QueueObject("priority: " + priority, LocalDateTime.now());

        defaultPriorityExchange.convertAndSend(object, (message) -> {
            message.getMessageProperties().setPriority(priority);
            return message;
        });

        return ResponseEntity.ok(true);
    }
}
