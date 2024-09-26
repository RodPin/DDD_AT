package br.edu.infnet.pedidopetfriends.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlmoxarifadoProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    public void prepararPedido(String estado) throws JsonProcessingException {
        amqpTemplate.convertAndSend("almoxarifado-exc", "almoxarifado-rk", objectMapper.writeValueAsString(estado));
    }
}
