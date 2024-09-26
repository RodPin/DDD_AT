package br.edu.infnet.pedidopetfriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class AlmoxarifadoController {

    @Autowired
    private PedidoService pedidoService;

    // Endpoint to update the state of a Pedido
    @PutMapping("/pedido/{pedidoId}/estado")
    public ResponseEntity<Void> atualizarEstadoPedido(@PathVariable String pedidoId, @RequestBody String estado) {
        try {
            pedidoService.atualiza(pedidoId, estado);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Handle exceptions, e.g. pedido não encontrado
            return ResponseEntity.notFound().build();
        }
    }
}