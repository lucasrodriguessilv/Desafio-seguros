package br.com.seguradora.model.entities;

import jakarta.persistence.*;

@Entity
public class Cobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private double fatorPeso;

    public Cobertura() {}

    public Cobertura(String tipo, double fatorPeso) {
        this.tipo = tipo;
        this.fatorPeso = fatorPeso;
    }

    public Long getId() { return id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public double getFatorPeso() { return fatorPeso; }
    public void setFatorPeso(double fatorPeso) { this.fatorPeso = fatorPeso; }
}
