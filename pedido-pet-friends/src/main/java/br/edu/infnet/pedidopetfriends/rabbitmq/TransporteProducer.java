package br.edu.infnet.pedidopetfriends.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransporteProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    public void buscarPedido(String estado) throws JsonProcessingException {
        amqpTemplate.convertAndSend("transporte-exc", "transporte-rk", objectMapper.writeValueAsString(estado));
    }
}
