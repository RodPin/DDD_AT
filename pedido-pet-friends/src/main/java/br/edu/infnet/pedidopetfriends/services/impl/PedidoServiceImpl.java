import br.edu.infnet.pedidopetfriends.domain.Pedido;
import br.edu.infnet.pedidopetfriends.repository.PedidoRepository;
import br.edu.infnet.pedidopetfriends.rabbitmq.AlmoxarifadoProducer;
import br.edu.infnet.pedidopetfriends.rabbitmq.TransporteProducer;
import br.edu.infnet.pedidopetfriends.services.PedidoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final TransporteProducer transporteProducer;
    private final AlmoxarifadoProducer almoxarifadoProducer;
    private final PedidoRepository pedidoRepository;
    @Override
    public String alterarEstadoPedido(String pedidoId, String estado) {
         // Atualiza o estado do pedido no repositório
         Pedido pedido = pedidoRepository.findById(pedidoId)
         .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        if ("FECHADO".equals(estado)) {
            almoxarifadoProducer.prepararPedido(pedidoId);
        } else if ("EM_PREPARACAO".equals(estado)) {
            transporteProducer.buscarPedido(pedidoId);
        }

        pedido.setEstado(estado); // Supondo que existe um método setEstado
        pedidoRepository.save(pedido); // Salva as alterações

        return "Estado do pedido atualizado com sucesso.";
    }

}
