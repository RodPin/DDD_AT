package br.edu.infnet.transportepetfriends.repository;

import br.edu.infnet.transportepetfriends.domain.Transporte;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoTranporteRepository extends MongoRepository<Transporte, String> {
}
