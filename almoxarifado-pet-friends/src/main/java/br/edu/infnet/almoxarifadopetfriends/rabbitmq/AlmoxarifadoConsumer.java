package br.edu.infnet.almoxarifadopetfriends.rabbitmq;

import br.edu.infnet.almoxarifadopetfriends.domain.Pedido;
import br.edu.infnet.almoxarifadopetfriends.service.impl.AlmoxarifadoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlmoxarifadoConsumer {

    private final AlmoxarifadoServiceImpl almoxarifadoService;

    @RabbitListener(queues = {"almoxarifado-queue"})
    public void prepararPedido(@Payload String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Pedido pedido = mapper.readValue(message, Pedido.class);
        almoxarifadoService.prepararPedido(pedido);
    }
}
