package br.com.hexagonal.demo.adapter.pessoa.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PessoaDTO extends Adto<Long> {
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String sobrenome;
    @NotNull
    private LocalDate dtNacimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDtNacimento() {
        return dtNacimento;
    }

    public void setDtNacimento(LocalDate dtNacimento) {
        this.dtNacimento = dtNacimento;
    }
}
