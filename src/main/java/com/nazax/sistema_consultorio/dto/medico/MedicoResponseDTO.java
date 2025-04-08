package com.nazax.sistema_consultorio.dto.medico;

import com.nazax.sistema_consultorio.enums.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String crm;
    private Especialidade especialidade;
}
