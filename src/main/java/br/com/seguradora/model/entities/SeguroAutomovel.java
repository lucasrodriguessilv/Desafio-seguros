package br.com.seguradora.model.entities;

import br.com.seguradora.model.abstractions.Seguro;
import br.com.seguradora.model.abstractions.Bem;
import br.com.seguradora.model.entities.CoberturaContratada;
import jakarta.persistence.Entity;
import java.util.List;

@Entity
public class SeguroAutomovel extends Seguro {

    public SeguroAutomovel() {}

    public SeguroAutomovel(Bem bem, List<CoberturaContratada> coberturas) {
        super(bem, coberturas);
    }

    @Override
    public double calcularPreco() {
        // reuse base calculation from Seguro (soma valorSegurado * fatorPeso)
        return super.calcularPreco();
    }
}
