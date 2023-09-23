package br.com.hexagonal.demo.application.pessoa.port;

import br.com.hexagonal.demo.application.pessoa.IServicePort;
import br.com.hexagonal.demo.application.pessoa.repository.PessoaRepository;
import br.com.hexagonal.demo.domain.model.Pessoa;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaServicePort implements IServicePort<Pessoa, Long> {

    private PessoaRepository repository;

    public PessoaServicePort(PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pessoa get(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Pessoa create(Pessoa entity) {
        return repository.save(entity);
    }

    @Override
    public List<Pessoa> list(Pageable pageable) {
        return repository.findAll(pageable).stream().toList();
    }
}
