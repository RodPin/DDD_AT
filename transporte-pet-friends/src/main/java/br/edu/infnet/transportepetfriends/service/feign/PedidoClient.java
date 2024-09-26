package br.edu.infnet.transportepetfriends.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PEDIDO-SERVICE")
public interface PedidoClient {
    @PutMapping("/atualiza-estado")
    String atualizarEstadoPedido(@RequestBody String estado);
}