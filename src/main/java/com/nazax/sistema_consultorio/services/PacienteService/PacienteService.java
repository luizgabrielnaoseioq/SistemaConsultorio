package com.nazax.sistema_consultorio.services.PacienteService;

import com.nazax.sistema_consultorio.dtos.paciente.PacienteRequestDTO;
import com.nazax.sistema_consultorio.dtos.paciente.PacienteResponseDTO;
import com.nazax.sistema_consultorio.models.Convenio;
import com.nazax.sistema_consultorio.models.Paciente;
import com.nazax.sistema_consultorio.repositories.ConvenioRepository;
import com.nazax.sistema_consultorio.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ConvenioRepository convenioRepository;

    public PacienteResponseDTO criar(PacienteRequestDTO dto) {
        Paciente paciente = toEntity(dto);
        pacienteRepository.save(paciente);
        return PacienteResponseDTO.fromEntity(paciente);
    }

    public List<PacienteResponseDTO> listarTodos() {
        return pacienteRepository.findAll().stream()
                .map(PacienteResponseDTO::fromEntity)
                .toList();
    }

    public PacienteResponseDTO buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        return PacienteResponseDTO.fromEntity(paciente);
    }

    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());

        if (dto.getConvenioId() != null) {
            Convenio convenio = convenioRepository.findById(dto.getConvenioId())
                    .orElseThrow(() -> new EntityNotFoundException("Convênio não encontrado"));
            paciente.setConvenio(convenio);
        }

        pacienteRepository.save(paciente);
        return PacienteResponseDTO.fromEntity(paciente);
    }

    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }

    private Paciente toEntity(PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setTelefone(dto.getTelefone());

        if (dto.getConvenioId() != null) {
            Convenio convenio = convenioRepository.findById(dto.getConvenioId())
                    .orElseThrow(() -> new EntityNotFoundException("Convênio não encontrado"));
            paciente.setConvenio(convenio);
        }

        return paciente;
    }
}
