package com.nazax.sistema_consultorio.dtos.paciente;

import java.time.LocalDate;

public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Long convenioId;

    public PacienteResponseDTO() {
    }

    public PacienteResponseDTO(Long id, String nome, String cpf, LocalDate dataNascimento, Long convenioId) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.convenioId = convenioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getConvenioId() {
        return convenioId;
    }

    public void setConvenioId(Long convenioId) {
        this.convenioId = convenioId;
    }
}