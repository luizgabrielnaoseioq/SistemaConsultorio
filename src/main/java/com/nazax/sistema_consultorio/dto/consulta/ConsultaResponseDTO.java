package com.nazax.sistema_consultorio.dto.consulta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaResponseDTO {
    private Long id;
    private String nomePaciente;
    private String nomeMedico;
    private LocalDateTime dataHora;
    private String observacoes;
}

