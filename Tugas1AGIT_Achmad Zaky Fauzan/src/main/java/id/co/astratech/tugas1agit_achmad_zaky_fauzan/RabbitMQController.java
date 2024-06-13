package id.co.astratech.tugas1agit_achmad_zaky_fauzan;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String  routingKey = "ZakyQueue";

    private static final String exchange = "ZakyExchange";

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public DtoResponse kirimPesan(@RequestBody String pesan){
        rabbitTemplate.convertAndSend(exchange, routingKey, pesan);
        return new DtoResponse(200, "Sending message to RabbitMQ: " + pesan,"Success");
    }

}