package br.edu.infnet.almoxarifadopetfriends.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class ItemAlmoxarifado {
    @AggregateIdentifier
    @Id
    private String id;
    public String nome;
    public Detalhes detalhes;
    public int quantidade;
}
