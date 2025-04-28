package com.nazax.sistema_consultorio.services.PacienteService;

import com.nazax.sistema_consultorio.dtos.paciente.PacienteRequestDTO;
import com.nazax.sistema_consultorio.dtos.paciente.PacienteResponseDTO;
import com.nazax.sistema_consultorio.models.Paciente;
import com.nazax.sistema_consultorio.repositories.PacienteRepository;
import com.nazax.sistema_consultorio.services.PacienteService.Mappers.PacienteMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Override
    public PacienteResponseDTO criar(PacienteRequestDTO dto) {
        Paciente paciente = pacienteMapper.toEntity(dto);
        pacienteRepository.save(paciente);
        return pacienteMapper.toDTO(paciente);
    }

    @Override
    public List<PacienteResponseDTO> listarTodos() {
        return pacienteRepository.findAll().stream()
                .map(pacienteMapper::toDTO)
                .toList();
    }

    @Override
    public PacienteResponseDTO buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente com ID " + id + " não encontrado"));
        return pacienteMapper.toDTO(paciente);
    }

    @Override
    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente com ID " + id + " não encontrado"));

        if (dto.getCpf() == null || dto.getCpf().isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser nulo ou vazio");
        }

        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setDataNascimento(dto.getDataNascimento());

        pacienteRepository.save(paciente);
        return pacienteMapper.toDTO(paciente);
    }

    @Override
    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }
}