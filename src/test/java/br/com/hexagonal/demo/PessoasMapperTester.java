package br.com.hexagonal.demo;

import br.com.hexagonal.demo.adapter.mapper.Mapper;
import br.com.hexagonal.demo.adapter.mapper.PessoaMapper;
import br.com.hexagonal.demo.adapter.pessoa.dto.PessoaDTO;
import br.com.hexagonal.demo.domain.model.Pessoa;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoasMapperTester {
    private Mapper<Pessoa, PessoaDTO> mapper = PessoaMapper.PESSOA_REST_MAPPER;

    @Test
    void toDto() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("nome");
        pessoa.setSobrenome("sobrenome");
        pessoa.setDtNacimento(LocalDate.now());
        PessoaDTO pessoaDTO = mapper.toDto(pessoa);
        assert (pessoaDTO.getId().equals(pessoa.getId()));
        assert (pessoaDTO.getNome().equals(pessoa.getNome()));
        assert (pessoaDTO.getSobrenome().equals(pessoa.getSobrenome()));
        assert (pessoaDTO.getDtNacimento().equals(pessoa.getDtNacimento()));
    }

    @Test
    void toEntity() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(1L);
        pessoaDTO.setNome("nome");
        pessoaDTO.setSobrenome("sobrenome");
        pessoaDTO.setDtNacimento(LocalDate.now());
        Pessoa pessoa = mapper.toEntity(pessoaDTO);
        assert (pessoaDTO.getId().equals(pessoa.getId()));
        assert (pessoaDTO.getNome().equals(pessoa.getNome()));
        assert (pessoaDTO.getSobrenome().equals(pessoa.getSobrenome()));
        assert (pessoaDTO.getDtNacimento().equals(pessoa.getDtNacimento()));

    }
}
