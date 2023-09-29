package br.com.hexagonal.demo.adapter.mapper;

import br.com.hexagonal.demo.adapter.pessoa.dto.PessoaDTO;
import br.com.hexagonal.demo.domain.model.Pessoa;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaMapper implements Mapper<Pessoa, PessoaDTO> {

    public static PessoaMapper PESSOA_REST_MAPPER = new PessoaMapper();

    public PessoaDTO toDto(Pessoa entity) {
        final PessoaDTO p = new PessoaDTO();
        p.setId(entity.getId());
        p.setNome(entity.getNome());
        p.setSobrenome(entity.getSobrenome());
        p.setDtNacimento(entity.getDtNacimento());
        return p;
    }

    public Pessoa toEntity(PessoaDTO dto) {
        final Pessoa p = new Pessoa();
        p.setId(dto.getId());
        p.setNome(dto.getNome());
        p.setSobrenome(dto.getSobrenome());
        p.setDtNacimento(dto.getDtNacimento());
        return p;
    }

    public List<PessoaDTO> toListDto(List<Pessoa> list) {
        return list.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
