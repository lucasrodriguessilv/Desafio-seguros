package br.com.seguradora.model.entities;

import br.com.seguradora.model.abstractions.Seguro;
import br.com.seguradora.model.abstractions.Bem;
import jakarta.persistence.Entity;
import java.util.List;

@Entity
public class SeguroAutomovel extends Seguro {

    public SeguroAutomovel() {}

    public SeguroAutomovel(Bem bem, List<Cobertura> coberturas) {
        super(bem, coberturas);
    }

    @Override
    public double calcularPreco() {
        double soma = getCoberturas().stream()
                .mapToDouble(c -> 1000.0 * c.getFatorPeso())
                .sum();
        setValorTotal(soma);
        return soma;
    }
}
