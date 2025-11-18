package br.com.seguradora.model.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<br.com.seguradora.model.abstractions.Seguro> seguros = new ArrayList<>();

    public Cliente() {}

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<br.com.seguradora.model.abstractions.Seguro> getSeguros() { return seguros; }
    public void setSeguros(List<br.com.seguradora.model.abstractions.Seguro> seguros) {
        this.seguros.clear();
        if (seguros != null) {
            seguros.forEach(this::addSeguro);
        }
    }

    public void addSeguro(br.com.seguradora.model.abstractions.Seguro seguro) {
        seguro.setCliente(this);
        this.seguros.add(seguro);
    }

    public void removeSeguro(br.com.seguradora.model.abstractions.Seguro seguro) {
        this.seguros.remove(seguro);
        seguro.setCliente(null);
    }
}
