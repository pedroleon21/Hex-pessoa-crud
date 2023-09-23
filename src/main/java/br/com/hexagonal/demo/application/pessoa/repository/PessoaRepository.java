package br.com.hexagonal.demo.application.pessoa.repository;

import br.com.hexagonal.demo.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
