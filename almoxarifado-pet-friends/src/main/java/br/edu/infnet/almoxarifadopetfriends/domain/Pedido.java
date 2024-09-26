package br.edu.infnet.almoxarifadopetfriends.domain;

import lombok.Data;

import java.util.List;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


@Data
@Aggregate
public class Pedido {

    @AggregateIdentifier
    private String id;
    private String clienteId;
    private List<String> itemsId;
    private double valor;
    private String estado;
}
