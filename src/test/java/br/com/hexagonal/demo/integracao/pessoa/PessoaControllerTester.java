package br.com.hexagonal.demo.integracao.pessoa;

import br.com.hexagonal.demo.DemoApplication;
import br.com.hexagonal.demo.adapter.pessoa.dto.PessoaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaControllerTester {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void post() throws Exception {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("John");
        pessoaDTO.setSobrenome("Doe");
        pessoaDTO.setDtNacimento(LocalDate.now());

        String jsonRequest = objectMapper.writeValueAsString(pessoaDTO);

        pessoaDTO.setId(1L);
        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(pessoaDTO)));
    }

    @Test
    @Order(2)
    void update() throws Exception {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(1L); // Assuming there is an existing pessoa with ID 1
        pessoaDTO.setNome("Updated Name");
        pessoaDTO.setSobrenome("Updated Last Name");
        pessoaDTO.setDtNacimento(LocalDate.of(1995, 6, 15)); // Corrected date format

        String jsonRequest = objectMapper.writeValueAsString(pessoaDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(3)
    void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pessoa/list"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(4)
    void delete() throws Exception {
        Long idToDelete = 1L; // Assuming there is an existing pessoa with ID 1

        mockMvc.perform(MockMvcRequestBuilders.delete("/pessoa/{id}", idToDelete))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
