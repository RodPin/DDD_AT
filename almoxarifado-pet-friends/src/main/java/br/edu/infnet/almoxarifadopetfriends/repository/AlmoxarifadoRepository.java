package br.edu.infnet.almoxarifadopetfriends.repository;

import br.edu.infnet.almoxarifadopetfriends.domain.ItemAlmoxarifado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmoxarifadoRepository extends MongoRepository<ItemAlmoxarifado, String> {
}
