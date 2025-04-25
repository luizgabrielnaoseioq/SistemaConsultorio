package com.nazax.sistema_consultorio.dtos.medico;

import com.nazax.sistema_consultorio.enums.Especialidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MedicoRequestDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String crm;

    @NotNull
    private Especialidade especialidade;
}


