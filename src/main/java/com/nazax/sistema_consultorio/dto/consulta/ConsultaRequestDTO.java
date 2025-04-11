package com.nazax.sistema_consultorio.dto.consulta;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaRequestDTO {
    @NotNull
    private Long pacienteId;

    @NotNull
    private Long medicoId;

    @NotNull
    private LocalDateTime dataHora;
}
