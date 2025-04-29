package com.nazax.sistema_consultorio.services.PacienteService;

import com.nazax.sistema_consultorio.dtos.paciente.PacienteRequestDTO;
import com.nazax.sistema_consultorio.dtos.paciente.PacienteResponseDTO;

import java.util.List;

public interface PacienteService {
    PacienteResponseDTO salvar(PacienteRequestDTO dto);
    PacienteResponseDTO buscarPorId(Long id);
    List<PacienteResponseDTO> listarTodos();
    PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto);
    void deletar(Long id);
}
