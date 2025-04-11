package com.nazax.sistema_consultorio.dto.paciente;

import lombok.Data;

@Data
public class PacienteRequestDTO {

    private String nome;

    private String cpf;

    private String telefone;

    private Long convenioId;
}


