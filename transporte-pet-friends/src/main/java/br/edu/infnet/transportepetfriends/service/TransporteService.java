package br.edu.infnet.transportepetfriends.service;

import br.edu.infnet.transportepetfriends.domain.Transporte;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface TransporteService {
    void buscarPedido(String pedidoId) throws JsonProcessingException;
    void entregaPedido(String pedidoId) throws JsonProcessingException;
}
