package br.edu.infnet.transportepetfriends.domain;

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
public class Transporte {
    @Id
    @AggregateIdentifier
    private Long id;
    public String[] pedidosId;
    public String caminhaoId;
    public String motoristaId;
    public Endereco endereco;
}
