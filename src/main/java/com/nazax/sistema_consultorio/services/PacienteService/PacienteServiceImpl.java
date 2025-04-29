package com.nazax.sistema_consultorio.services.PacienteService;


import com.nazax.sistema_consultorio.dtos.paciente.PacienteRequestDTO;
import com.nazax.sistema_consultorio.dtos.paciente.PacienteResponseDTO;
import com.nazax.sistema_consultorio.models.Paciente;
import com.nazax.sistema_consultorio.repositories.PacienteRepository;
import com.nazax.sistema_consultorio.services.PacienteService.Mappers.PacienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Override
    public PacienteResponseDTO salvar(PacienteRequestDTO dto) {
        Paciente paciente = PacienteMapper.toEntity(dto);
        return PacienteMapper.toResponse(repository.save(paciente));
    }

    @Override
    public PacienteResponseDTO buscarPorId(Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        return PacienteMapper.toResponse(paciente);
    }

    @Override
    public List<PacienteResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(PacienteMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setConvenioId(dto.getConvenioId());
        return PacienteMapper.toResponse(repository.save(paciente));
    }

    @Override
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Paciente não encontrado");
        }
        repository.deleteById(id);
    }
}
