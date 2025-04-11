package com.nazax.sistema_consultorio.dto.medico;

import com.nazax.sistema_consultorio.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String crm;
    private String especialidade;

    public static MedicoResponseDTO fromEntity(Medico medico) {
        return new MedicoResponseDTO(
                medico.getId(),
                medico.getNome(),
                medico.getCrm(),
                medico.getEspecialidade().name()
        );
    }
}

