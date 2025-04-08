package com.nazax.sistema_consultorio.service;

import com.nazax.sistema_consultorio.dto.paciente.PacienteRequestDTO;
import com.nazax.sistema_consultorio.dto.paciente.PacienteResponseDTO;
import com.nazax.sistema_consultorio.model.Convenio;
import com.nazax.sistema_consultorio.model.Paciente;
import com.nazax.sistema_consultorio.repository.ConvenioRepository;
import com.nazax.sistema_consultorio.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepo;
    private final ConvenioRepository convenioRepo;

    public List<PacienteResponseDTO> listarTodos() {
        return pacienteRepo.findAll().stream().map(p -> new PacienteResponseDTO(
                p.getId(), p.getNome(), p.getCpf(), p.getTelefone(), p.getConvenio().getNome()
        )).collect(Collectors.toList());
    }

    public void salvar(PacienteRequestDTO dto) {
        Convenio convenio = convenioRepo.findById(dto.getConvenioId()).orElseThrow();
        Paciente paciente = new Paciente(null, dto.getNome(), dto.getCpf(), dto.getTelefone(), convenio);
        pacienteRepo.save(paciente);
    }
}