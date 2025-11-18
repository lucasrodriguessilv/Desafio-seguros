package br.com.seguradora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.com.seguradora.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;

import br.com.seguradora.model.entities.Cliente;
import br.com.seguradora.model.abstractions.Seguro;

@SpringBootApplication
public class SeguradoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeguradoraApplication.class, args);
    }

    @Bean
    CommandLineRunner printSummary(ClienteRepository clienteRepository) {
        return args -> {
            System.out.println("--- Resumo Seguradora (DataInitializer populou amostra) ---");
            for (Cliente c : clienteRepository.findAll()) {
                System.out.println("Cliente: " + c.getNome());
                for (Seguro s : c.getSeguros()) {
                    System.out.println("  Seguro id=" + s.getId() + " Bem=" + (s.getBem() != null ? s.getBem().getDescricao() : "-") + " Preco=" + s.getValorTotal());
                }
            }
        };
    }
}
