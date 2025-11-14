package br.com.seguradora.repository;

import br.com.seguradora.model.entities.SeguroAutomovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends JpaRepository<SeguroAutomovel, Long> {
}
