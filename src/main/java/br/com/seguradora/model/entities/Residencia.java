package br.com.seguradora.model.entities;

import br.com.seguradora.model.abstractions.Bem;
import jakarta.persistence.Entity;

@Entity
public class Residencia extends Bem {

    private String endereco;
    private double areaConstruida;

    public Residencia() {}

    public Residencia(String descricao, String endereco, double areaConstruida) {
        super(descricao);
        this.endereco = endereco;
        this.areaConstruida = areaConstruida;
    }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public double getAreaConstruida() { return areaConstruida; }
    public void setAreaConstruida(double areaConstruida) { this.areaConstruida = areaConstruida; }
}
