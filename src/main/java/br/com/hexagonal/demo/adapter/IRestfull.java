package br.com.hexagonal.demo.adapter;

import br.com.hexagonal.demo.adapter.pessoa.dto.PessoaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface IRestfull<D, I> {
    public D get(I id);

    @GetMapping("{id}")
    PessoaDTO get(@PathVariable Long id);

    public List<PessoaDTO> list(Pageable pageable);

    public D create(D dto);

    public void delete(I id);

    @PostMapping
    PessoaDTO create(PessoaDTO dto);

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id);
}
