package br.com.fiap.checkpoint2.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class ProfissionalCreateDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String especialidade;
    private BigDecimal valorHora;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }
}