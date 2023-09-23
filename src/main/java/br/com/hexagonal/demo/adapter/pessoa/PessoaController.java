package br.com.hexagonal.demo.adapter.pessoa;

import br.com.hexagonal.demo.adapter.IRestfull;
import br.com.hexagonal.demo.adapter.pessoa.dto.PessoaDTO;
import br.com.hexagonal.demo.application.pessoa.port.PessoaServicePort;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.hexagonal.demo.adapter.mapper.PessoaMapper.PESSOA_REST_MAPPER;

@RestController
@RequestMapping("pessoa")
public class PessoaController implements IRestfull<PessoaDTO, Long> {

    private PessoaServicePort service;


    public PessoaController(PessoaServicePort service) {
        this.service = service;
    }

    @Override
    @GetMapping("{id}")
    public PessoaDTO get(@PathVariable Long id) {
        return PESSOA_REST_MAPPER.toDto(service.get(id));
    }

    @Override
    @GetMapping("list")
    public List<PessoaDTO> list(Pageable pageable) {
        return PESSOA_REST_MAPPER.toListDto(service.list(pageable));
    }

    @Override
    @PostMapping
    public PessoaDTO create(@Valid @RequestBody PessoaDTO dto) {
        return PESSOA_REST_MAPPER.toDto(
                service.create(PESSOA_REST_MAPPER.toEntity(dto))
        );
    }

    @Override
    @PutMapping
    public PessoaDTO update(@Valid PessoaDTO dto) {
        return PESSOA_REST_MAPPER.toDto(
                service.create(PESSOA_REST_MAPPER.toEntity(dto))
        );
    }

    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
