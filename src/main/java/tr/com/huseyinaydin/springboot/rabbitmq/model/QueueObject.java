package tr.com.huseyinaydin.springboot.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

//بسم الله الرحمن الرحيم

/**
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, RabbitMQ.
* 
*/

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QueueObject
{
    private String type;

    private LocalDateTime time;
}
