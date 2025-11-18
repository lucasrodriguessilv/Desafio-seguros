package br.com.seguradora.config;

import br.com.seguradora.model.entities.Automovel;
import br.com.seguradora.model.entities.Cobertura;
import br.com.seguradora.model.entities.Cliente;
import br.com.seguradora.model.entities.SeguroAutomovel;
import br.com.seguradora.model.entities.CoberturaContratada;
import br.com.seguradora.repository.ClienteRepository;
import br.com.seguradora.repository.CoberturaRepository;
import br.com.seguradora.repository.SeguroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
    private final CoberturaRepository coberturaRepository;
    private final SeguroRepository seguroRepository;

    public DataInitializer(ClienteRepository clienteRepository,
                           CoberturaRepository coberturaRepository,
                           SeguroRepository seguroRepository) {
        this.clienteRepository = clienteRepository;
        this.coberturaRepository = coberturaRepository;
        this.seguroRepository = seguroRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Apenas popula dados se estiver vazio
        if (clienteRepository.count() > 0) return;

        Cobertura colisao = new Cobertura("Colisão", 1.2);
        Cobertura roubo = new Cobertura("Roubo", 1.5);

        // Salvar coberturas no catálogo primeiro
        coberturaRepository.saveAll(Arrays.asList(colisao, roubo));

        Automovel auto = new Automovel("Carro pessoal", "ABC-1234", "Gol", 2018);

        // Cliente define valores segurados para cada cobertura escolhida
        CoberturaContratada cc1 = new CoberturaContratada(colisao, 30000.0);
        CoberturaContratada cc2 = new CoberturaContratada(roubo, 20000.0);

        SeguroAutomovel seguro = new SeguroAutomovel(auto, Arrays.asList(cc1, cc2));
        seguro.calcularPreco();

        // Persistir o cliente com cascade para seguros e coberturas contratadas
        Cliente cliente = new Cliente("Cliente Exemplo");
        cliente.addSeguro(seguro);
        clienteRepository.save(cliente);
    }
}
