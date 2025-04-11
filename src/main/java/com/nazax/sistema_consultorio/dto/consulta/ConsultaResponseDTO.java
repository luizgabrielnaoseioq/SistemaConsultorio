package com.nazax.sistema_consultorio.dto.consulta;


import com.nazax.sistema_consultorio.model.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ConsultaResponseDTO {
    private Long id;
    private String nomePaciente;
    private String nomeMedico;
    private LocalDateTime dataHora;

    public static ConsultaResponseDTO fromEntity(Consulta consulta) {
        return new ConsultaResponseDTO(
                consulta.getId(),
                consulta.getPaciente().getNome(),
                consulta.getMedico().getNome(),
                consulta.getDataHora()
        );
    }
}
