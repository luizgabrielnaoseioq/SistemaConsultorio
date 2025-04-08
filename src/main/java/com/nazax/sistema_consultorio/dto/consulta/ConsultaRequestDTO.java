package com.nazax.sistema_consultorio.dto.consulta;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaRequestDTO {
    private Long pacienteId;
    private Long medicoId;
    private LocalDateTime dataHora;
    private String observacoes;
}
