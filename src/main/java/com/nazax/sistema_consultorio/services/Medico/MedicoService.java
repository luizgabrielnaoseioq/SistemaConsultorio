package com.nazax.sistema_consultorio.services.Medico;

import com.nazax.sistema_consultorio.dtos.medico.MedicoRequestDTO;
import com.nazax.sistema_consultorio.dtos.medico.MedicoResponseDTO;

import java.util.List;

public interface MedicoService {
    MedicoResponseDTO criar(MedicoRequestDTO dto);
    List<MedicoResponseDTO> listarTodos();
    MedicoResponseDTO buscarPorId(Long id);
    MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto);
    void deletar(Long id);
}
