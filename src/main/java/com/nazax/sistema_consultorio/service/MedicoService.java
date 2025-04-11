package com.nazax.sistema_consultorio.service;

import com.nazax.sistema_consultorio.dto.medico.MedicoRequestDTO;
import com.nazax.sistema_consultorio.dto.medico.MedicoResponseDTO;
import com.nazax.sistema_consultorio.model.Medico;
import com.nazax.sistema_consultorio.repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoResponseDTO criar(MedicoRequestDTO dto) {
        Medico medico = toEntity(dto);
        medicoRepository.save(medico);
        return MedicoResponseDTO.fromEntity(medico);
    }

    public List<MedicoResponseDTO> listarTodos() {
        return medicoRepository.findAll().stream()
                .map(MedicoResponseDTO::fromEntity)
                .toList();
    }

    public MedicoResponseDTO buscarPorId(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
        return MedicoResponseDTO.fromEntity(medico);
    }

    public MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());

        medicoRepository.save(medico);
        return MedicoResponseDTO.fromEntity(medico);
    }

    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }

    private Medico toEntity(MedicoRequestDTO dto) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());
        return medico;
    }
}
