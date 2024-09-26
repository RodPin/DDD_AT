package br.edu.infnet.almoxarifadopetfriends.service;

import br.edu.infnet.almoxarifadopetfriends.domain.Pedido;

public interface AlmoxarifadoService {
    int verificaDisponibilidadeItem(String itemId);
    void prepararPedido(Pedido pedido);
}
