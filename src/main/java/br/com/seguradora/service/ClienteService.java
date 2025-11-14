package br.com.seguradora.service;

import br.com.seguradora.model.entities.Cliente;
import br.com.seguradora.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente c) {
        return repository.save(c);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }
}
