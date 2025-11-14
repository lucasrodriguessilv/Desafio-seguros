package br.com.seguradora.model.entities;

import br.com.seguradora.model.abstractions.Bem;
import jakarta.persistence.Entity;

@Entity
public class Automovel extends Bem {

    private String placa;
    private String modelo;
    private int ano;

    public Automovel() {}

    public Automovel(String descricao, String placa, String modelo, int ano) {
        super(descricao);
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
}
