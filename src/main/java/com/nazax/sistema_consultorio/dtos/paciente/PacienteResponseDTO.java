package com.nazax.sistema_consultorio.dtos.paciente;

import com.nazax.sistema_consultorio.models.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String convenio;

    public static PacienteResponseDTO fromEntity(Paciente paciente) {
        String convenioNome = paciente.getConvenio() != null ? paciente.getConvenio().getNome() : null;
        return new PacienteResponseDTO(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), convenioNome);
    }
}
