package com.nazax.sistema_consultorio.service;

import com.nazax.sistema_consultorio.dto.medico.MedicoRequestDTO;
import com.nazax.sistema_consultorio.dto.medico.MedicoResponseDTO;
import com.nazax.sistema_consultorio.model.Medico;
import com.nazax.sistema_consultorio.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepo;

    public List<MedicoResponseDTO> listarTodos() {
        return medicoRepo.findAll().stream().map(m -> new MedicoResponseDTO(
                m.getId(), m.getNome(), m.getCrm(), m.getEspecialidade()
        )).collect(Collectors.toList());
    }

    public void salvar(MedicoRequestDTO dto) {
        Medico medico = new Medico(null, dto.getNome(), dto.getCrm(), dto.getEspecialidade());
        medicoRepo.save(medico);
    }
}