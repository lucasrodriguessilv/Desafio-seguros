package br.com.seguradora.service;

import br.com.seguradora.model.entities.SeguroAutomovel;
import br.com.seguradora.repository.SeguroRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SeguroService {

    private final SeguroRepository repository;

    public SeguroService(SeguroRepository repository) {
        this.repository = repository;
    }

    public SeguroAutomovel salvar(SeguroAutomovel seguro) {
        seguro.calcularPreco();
        return repository.save(seguro);
    }

    public Optional<SeguroAutomovel> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
