package com.nazax.sistema_consultorio.service;

import com.nazax.sistema_consultorio.dto.consulta.ConsultaRequestDTO;
import com.nazax.sistema_consultorio.dto.consulta.ConsultaResponseDTO;
import com.nazax.sistema_consultorio.model.Consulta;
import com.nazax.sistema_consultorio.model.Medico;
import com.nazax.sistema_consultorio.model.Paciente;
import com.nazax.sistema_consultorio.repository.ConsultaRepository;
import com.nazax.sistema_consultorio.repository.MedicoRepository;
import com.nazax.sistema_consultorio.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepo;
    private final MedicoRepository medicoRepo;
    private final PacienteRepository pacienteRepo;

    public List<ConsultaResponseDTO> listarTodos() {
        return consultaRepo.findAll().stream().map(c -> new ConsultaResponseDTO(
                c.getId(), c.getPaciente().getNome(), c.getMedico().getNome(), c.getDataHora(), c.getObservacoes()
        )).collect(Collectors.toList());
    }

    public void salvar(ConsultaRequestDTO dto) {
        Paciente paciente = pacienteRepo.findById(dto.getPacienteId()).orElseThrow();
        Medico medico = medicoRepo.findById(dto.getMedicoId()).orElseThrow();
        Consulta consulta = new Consulta(null, paciente, medico, dto.getDataHora(), dto.getObservacoes());
        consultaRepo.save(consulta);
    }
}