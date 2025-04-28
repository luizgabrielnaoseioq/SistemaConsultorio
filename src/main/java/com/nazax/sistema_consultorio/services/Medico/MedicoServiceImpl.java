package com.nazax.sistema_consultorio.services.Medico;

import com.nazax.sistema_consultorio.dtos.medico.MedicoRequestDTO;
import com.nazax.sistema_consultorio.dtos.medico.MedicoResponseDTO;
import com.nazax.sistema_consultorio.models.Medico;
import com.nazax.sistema_consultorio.repositories.MedicoRepository;
import com.nazax.sistema_consultorio.services.Medico.Mappers.MedicoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService{

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoMapper medicoMapper;

    @Override
    public MedicoResponseDTO criar(MedicoRequestDTO dto) {
        Medico medico = medicoMapper.toEntity(dto);
        medicoRepository.save(medico);
        return medicoMapper.toDTO(medico);
    }

    @Override
    public List<MedicoResponseDTO> listarTodos() {
        return medicoRepository.findAll().stream()
                .map(medicoMapper::toDTO)
                .toList();
    }

    @Override
    public MedicoResponseDTO buscarPorId(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
        return MedicoResponseDTO.fromEntity(medico);
    }

    @Override
    public MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto) {
       Medico medico = medicoRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
        if (dto.getCrm() == null || dto.getCrm().isEmpty()) {
            throw new IllegalArgumentException("O CRM não pode ser nulo ou vazio");
        }
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());
        medicoRepository.save(medico);
        return medicoMapper.toDTO(medico);
    }

    @Override
    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }
}
