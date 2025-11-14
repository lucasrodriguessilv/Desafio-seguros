package br.com.seguradora.model.abstractions;

import br.com.seguradora.model.entities.Cobertura;
import br.com.seguradora.model.interfaces.Calculavel;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Seguro implements Calculavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Bem bem;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "seguro_cobertura",
        joinColumns = @JoinColumn(name = "seguro_id"),
        inverseJoinColumns = @JoinColumn(name = "cobertura_id"))
    private List<Cobertura> coberturas;

    private double valorTotal;

    public Seguro() {}

    public Seguro(Bem bem, List<Cobertura> coberturas) {
        this.bem = bem;
        this.coberturas = coberturas;
    }

    public Long getId() { return id; }
    public Bem getBem() { return bem; }
    public List<Cobertura> getCoberturas() { return coberturas; }
    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
}
