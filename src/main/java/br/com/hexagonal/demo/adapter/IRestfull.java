package br.com.hexagonal.demo.adapter;

import br.com.hexagonal.demo.adapter.pessoa.dto.PessoaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IRestfull<D, I> {

    @GetMapping("{id}")
    PessoaDTO get(@PathVariable Long id);

    @GetMapping("list")
    List<PessoaDTO> list(Pageable pageable);

    @PostMapping
    PessoaDTO create(PessoaDTO dto);

    @PutMapping
    PessoaDTO update(@RequestBody PessoaDTO dto);

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id);
}
