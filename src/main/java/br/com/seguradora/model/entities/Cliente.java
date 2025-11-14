package br.com.seguradora.model.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    private List<br.com.seguradora.model.abstractions.Seguro> seguros;

    public Cliente() {}

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<br.com.seguradora.model.abstractions.Seguro> getSeguros() { return seguros; }
    public void setSeguros(List<br.com.seguradora.model.abstractions.Seguro> seguros) { this.seguros = seguros; }
}
