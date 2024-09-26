package br.edu.infnet.almoxarifadopetfriends.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Detalhes {

    private double altura;
    private double largura;
    private double profundidade;
    private boolean fragil;
    private double peso;

    public Detalhes(double altura, double largura, double profundidade, boolean fragil, double peso) {
        if (altura <= 0 || largura <= 0 || profundidade <= 0) {
            throw new IllegalArgumentException("As dimensões devem ser maiores que zero.");
        }
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.fragil = fragil;
        this.peso = peso;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("A altura deve ser maior que zero.");
        }
        this.altura = altura;
    }

    public void setLargura(double largura) {
        if (largura <= 0) {
            throw new IllegalArgumentException("A largura deve ser maior que zero.");
        }
        this.largura = largura;
    }

    public void setProfundidade(double profundidade) {
        if (profundidade <= 0) {
            throw new IllegalArgumentException("A profundidade deve ser maior que zero.");
        }
        this.profundidade = profundidade;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    public void setPeso(double peso) {
        if (peso < 0) {
            throw new IllegalArgumentException("O peso não pode ser negativo.");
        }
        this.peso = peso;
    }

    public double calcularVolume() {
        return altura * largura * profundidade;
    }

    public boolean dimensoesValidas() {
        return altura > 0 && largura > 0 && profundidade > 0;
    }
}
