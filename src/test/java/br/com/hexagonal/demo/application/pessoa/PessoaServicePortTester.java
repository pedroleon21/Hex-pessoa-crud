package br.com.hexagonal.demo.application.pessoa;

import br.com.hexagonal.demo.application.pessoa.port.PessoaServicePort;
import br.com.hexagonal.demo.application.pessoa.repository.PessoaRepository;
import br.com.hexagonal.demo.domain.model.Pessoa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PessoaServicePortTester {

    @Mock
    private PessoaRepository repository;

    private PessoaServicePort service;

    @BeforeAll
    void setup() {
        MockitoAnnotations.openMocks(this);
        service = new PessoaServicePort(repository);
    }

    @Test
    void testCreateNewPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("nome");
        pessoa.setSobrenome("sobrenome");
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        pessoa.setDtNacimento(birthDate);

        when(repository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa createdPessoa = service.create(pessoa);

        assertNotNull(createdPessoa);
        assertEquals("nome", createdPessoa.getNome());
        assertEquals("sobrenome", createdPessoa.getSobrenome());
        assertEquals(birthDate, createdPessoa.getDtNacimento());
    }

    @Test
    void testGetPessoaById() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome("nome");
        pessoa.setSobrenome("sobrenome");
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        pessoa.setDtNacimento(birthDate);

        when(repository.findById(id)).thenReturn(Optional.of(pessoa));

        Pessoa retrievedPessoa = service.get(id);

        assertNotNull(retrievedPessoa);
        assertEquals(id, retrievedPessoa.getId());
        assertEquals("nome", retrievedPessoa.getNome());
        assertEquals("sobrenome", retrievedPessoa.getSobrenome());
        assertEquals(birthDate, retrievedPessoa.getDtNacimento());
    }

    @Test
    void testDeletePessoa() {
        Long id = 1L;
        service.delete(id);
        verify(repository).deleteById(id);
    }

    @Test
    void testListPessoas() {
        Pageable pageable = Pageable.unpaged();

        when(repository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(
                new Pessoa(1L, "Nome1", "Sobrenome1", LocalDate.of(1990, 1, 1)),
                new Pessoa(2L, "Nome2", "Sobrenome2", LocalDate.of(1995, 5, 5))
        )));

        List<Pessoa> pessoas = service.list(pageable);

        assertEquals(2, pessoas.size());
        assertEquals(1L, pessoas.get(0).getId());
        assertEquals("Nome1", pessoas.get(0).getNome());
        assertEquals("Sobrenome1", pessoas.get(0).getSobrenome());
        assertEquals(LocalDate.of(1990, 1, 1), pessoas.get(0).getDtNacimento());
        assertEquals(2L, pessoas.get(1).getId());
        assertEquals("Nome2", pessoas.get(1).getNome());
        assertEquals("Sobrenome2", pessoas.get(1).getSobrenome());
        assertEquals(LocalDate.of(1995, 5, 5), pessoas.get(1).getDtNacimento());
    }
}
