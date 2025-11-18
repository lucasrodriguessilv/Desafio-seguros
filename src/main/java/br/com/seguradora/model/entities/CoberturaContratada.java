package br.com.seguradora.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cobertura_contratada")
public class CoberturaContratada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cobertura_id")
    private Cobertura cobertura;

    private double valorSegurado; // valor definido pelo cliente para esta cobertura

    @ManyToOne
    @JoinColumn(name = "seguro_id")
    private br.com.seguradora.model.abstractions.Seguro seguro;

    public CoberturaContratada() {}

    public CoberturaContratada(Cobertura cobertura, double valorSegurado) {
        this.cobertura = cobertura;
        this.valorSegurado = valorSegurado;
    }

    public Long getId() { return id; }
    public Cobertura getCobertura() { return cobertura; }
    public void setCobertura(Cobertura cobertura) { this.cobertura = cobertura; }
    public double getValorSegurado() { return valorSegurado; }
    public void setValorSegurado(double valorSegurado) { this.valorSegurado = valorSegurado; }
    public br.com.seguradora.model.abstractions.Seguro getSeguro() { return seguro; }
    public void setSeguro(br.com.seguradora.model.abstractions.Seguro seguro) { this.seguro = seguro; }
}
