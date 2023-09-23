package br.com.hexagonal.demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Pessoa extends AEntity<Long> {
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
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

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + getId() + '\'' +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dtNacimento=" + dtNacimento +
                '}';
    }
}
