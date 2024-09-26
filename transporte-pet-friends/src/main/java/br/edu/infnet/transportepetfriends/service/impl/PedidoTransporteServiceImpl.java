package br.edu.infnet.transportepetfriends.service.impl;

import br.edu.infnet.transportepetfriends.service.TransporteService;
import br.edu.infnet.transportepetfriends.service.feign.PedidoClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoTransporteServiceImpl implements TransporteService {

    private final PedidoClient pedidoClient;

    @Override
    public void buscarPedido(String pedidoId) throws JsonProcessingException {
        //Notifica o caminhoneiro que tem que buscar o pedido
        //Muda o estado do em para em transito
        pedidoClient.atualizarEstadoPedido("EM_TRANSITO");
    }

    @Override
    public void entregaPedido(String pedidoId) throws JsonProcessingException {
        //Entrega o pedido e muda o estado para entregue
        pedidoClient.atualizarEstadoPedido("ENTREGUE");
    }

}
