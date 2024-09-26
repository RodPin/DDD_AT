package br.edu.infnet.pedidopetfriends.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


@Data
@Aggregate
@Entity
public class Pedido {

    @AggregateIdentifier
    @Id
    private String id;
    private String clienteId;
    private String[] itemsId;
    private double valor;
    private String estado;
}
