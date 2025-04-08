package com.nazax.sistema_consultorio.dto.paciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String convenio;
}