package br.com.seguradora.repository;

import br.com.seguradora.model.entities.Cobertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoberturaRepository extends JpaRepository<Cobertura, Long> {
}
