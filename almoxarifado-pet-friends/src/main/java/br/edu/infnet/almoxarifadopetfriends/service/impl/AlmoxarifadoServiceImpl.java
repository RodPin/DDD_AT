package br.edu.infnet.almoxarifadopetfriends.service.impl;

import br.edu.infnet.almoxarifadopetfriends.domain.ItemAlmoxarifado;
import br.edu.infnet.almoxarifadopetfriends.domain.Pedido;
import br.edu.infnet.almoxarifadopetfriends.repository.AlmoxarifadoRepository;
import br.edu.infnet.almoxarifadopetfriends.service.AlmoxarifadoService;
import br.edu.infnet.almoxarifadopetfriends.service.feign.PedidoClient;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlmoxarifadoServiceImpl implements AlmoxarifadoService {

    private final AlmoxarifadoRepository almoxarifadoRepository;
    private final PedidoClient pedidoClient;
 
    @Override
    public int verificaDisponibilidadeItem(String itemId) {
        ItemAlmoxarifado item = almoxarifadoRepository.findById(itemId).orElse(null);
        if (item != null) {
            return item.quantidade;
        }
        return 0;
    }
    public void diminuirQuantidade(List<String> itemIds) {
        // Busca os itens pelo ID
        List<ItemAlmoxarifado> items = almoxarifadoRepository.findAllById(itemIds);

        // Itera sobre os itens e diminui a quantidade
        for (ItemAlmoxarifado item : items) {
            if (item.getQuantidade() > 0) { // Verifica se a quantidade é maior que 0
                item.setQuantidade(item.getQuantidade() - 1); // Diminui a quantidade em 1
                almoxarifadoRepository.save(item); // Salva as alterações
            } 
        }
    }
    @Override
    public void prepararPedido(Pedido pedido) {
        List<String> itemIds = pedido.getItemsId();
        this.diminuirQuantidade(itemIds);
        //Prepara os pedidos e entrega pro transporte
        pedidoClient.atualizarEstadoPedido("EM_PREPARACAO");
    }
}
