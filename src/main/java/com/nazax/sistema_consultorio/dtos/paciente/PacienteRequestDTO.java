package com.nazax.sistema_consultorio.dtos.paciente;

import lombok.Data;

@Data
public class PacienteRequestDTO {

    private String nome;

    private String cpf;

    private String telefone;

    private Long convenioId;
}


