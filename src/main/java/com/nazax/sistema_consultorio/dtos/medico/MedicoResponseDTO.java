package com.nazax.sistema_consultorio.dtos.medico;

import com.nazax.sistema_consultorio.enums.Especialidade;
import com.nazax.sistema_consultorio.models.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String crm;
    private String especialidade;

    public MedicoResponseDTO() {

    }

    public static MedicoResponseDTO fromEntity(Medico medico) {
        return new MedicoResponseDTO(
                medico.getId(),
                medico.getNome(),
                medico.getCrm(),
                medico.getEspecialidade().name()
        );
    }

    public void setEspecialidade(Especialidade especialidade) {
    }
}

