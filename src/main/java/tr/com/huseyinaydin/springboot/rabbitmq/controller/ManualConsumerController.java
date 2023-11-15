package tr.com.huseyinaydin.springboot.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.huseyinaydin.springboot.rabbitmq.consumer.ManualConsumer;

//بسم الله الرحمن الرحيم

/**
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, RabbitMQ.
* 
*/

@RestController
public class ManualConsumerController
{
    @Autowired
    private ManualConsumer manualConsumer;

    @PostMapping("consume/{queueName}")
    public ResponseEntity<?> consumeAllMessagesOfQueue(@PathVariable String queueName)
    {
        return ResponseEntity.ok(manualConsumer.receiveMessages(queueName));
    }
}
