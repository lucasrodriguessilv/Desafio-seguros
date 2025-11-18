package br.com.seguradora.model.abstractions;

import jakarta.persistence.*;

@Entity
@Table(name = "bem")
public abstract class Bem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    public Bem() {}

    public Bem(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() { return id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
