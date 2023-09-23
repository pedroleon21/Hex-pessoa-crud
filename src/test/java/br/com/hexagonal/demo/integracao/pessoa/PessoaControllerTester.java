package br.com.hexagonal.demo.integracao.pessoa;

import br.com.hexagonal.demo.adapter.pessoa.dto.PessoaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest

public class PessoaControllerTester {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void post() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa", new PessoaDTO()))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Expected Response Body"));
    }
}
