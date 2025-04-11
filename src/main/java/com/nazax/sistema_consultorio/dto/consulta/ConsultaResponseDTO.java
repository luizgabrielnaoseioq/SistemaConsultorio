package com.nazax.sistema_consultorio.dto.consulta;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaResponseDTO {
    private Long id;
    private String nomePaciente;
    private String nomeMedico;
    private LocalDateTime dataHora;
    private String observacoes;

    public ConsultaResponseDTO() {

    }

    public ConsultaResponseDTO(Long id, String nomePaciente, String nomeMedico, LocalDateTime dataHora, String observacoes) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeMedico;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

