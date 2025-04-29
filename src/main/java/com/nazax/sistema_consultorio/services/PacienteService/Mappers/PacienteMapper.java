package com.nazax.sistema_consultorio.services.PacienteService.Mappers;

import com.nazax.sistema_consultorio.dtos.paciente.PacienteRequestDTO;
import com.nazax.sistema_consultorio.dtos.paciente.PacienteResponseDTO;
import com.nazax.sistema_consultorio.models.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public static Paciente toEntity(PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setConvenioId(dto.getConvenioId());
        return paciente;
    }

    public static PacienteResponseDTO toResponse(Paciente paciente) {
        PacienteResponseDTO response = new PacienteResponseDTO();
        response.setId(paciente.getId());
        response.setNome(paciente.getNome());
        response.setCpf(paciente.getCpf());
        response.setDataNascimento(paciente.getDataNascimento());
        response.setConvenioId(paciente.getConvenioId());
        return response;
    }
}