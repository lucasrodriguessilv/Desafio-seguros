package br.com.seguradora.model.abstractions;

import br.com.seguradora.model.entities.CoberturaContratada;
import br.com.seguradora.model.interfaces.Calculavel;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Seguro implements Calculavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Bem bem;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private br.com.seguradora.model.entities.Cliente cliente;

    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CoberturaContratada> coberturas = new ArrayList<>();

    private double valorTotal;

    public Seguro() {}

    public Seguro(Bem bem, List<CoberturaContratada> coberturas) {
        this.bem = bem;
        this.coberturas = coberturas;
        if (this.coberturas != null) {
            this.coberturas.forEach(c -> c.setSeguro(this));
        }
    }

    public Long getId() { return id; }
    public Bem getBem() { return bem; }
    public List<CoberturaContratada> getCoberturas() { return coberturas; }
    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public void addCoberturaContratada(CoberturaContratada cc) {
        cc.setSeguro(this);
        coberturas.add(cc);
    }

    public void removeCoberturaContratada(CoberturaContratada cc) {
        coberturas.remove(cc);
        cc.setSeguro(null);
    }

    public br.com.seguradora.model.entities.Cliente getCliente() { return cliente; }
    public void setCliente(br.com.seguradora.model.entities.Cliente cliente) { this.cliente = cliente; }

    @Override
    public double calcularPreco() {
        double soma = coberturas.stream()
                .mapToDouble(cc -> cc.getValorSegurado() * cc.getCobertura().getFatorPeso())
                .sum();
        setValorTotal(soma);
        return soma;
    }
}
