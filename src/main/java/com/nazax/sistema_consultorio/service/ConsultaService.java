package com.nazax.sistema_consultorio.service;

import com.nazax.sistema_consultorio.dto.consulta.ConsultaRequestDTO;
import com.nazax.sistema_consultorio.dto.consulta.ConsultaResponseDTO;
import com.nazax.sistema_consultorio.model.Consulta;
import com.nazax.sistema_consultorio.model.Medico;
import com.nazax.sistema_consultorio.model.Paciente;
import com.nazax.sistema_consultorio.repository.ConsultaRepository;
import com.nazax.sistema_consultorio.repository.MedicoRepository;
import com.nazax.sistema_consultorio.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaResponseDTO criar(ConsultaRequestDTO dto) {
        Consulta consulta = toEntity(dto);
        consultaRepository.save(consulta);
        return ConsultaResponseDTO.fromEntity(consulta);
    }

    public List<ConsultaResponseDTO> listarTodos() {
        return consultaRepository.findAll().stream()
                .map(ConsultaResponseDTO::fromEntity)
                .toList();
    }

    public ConsultaResponseDTO buscarPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada"));
        return ConsultaResponseDTO.fromEntity(consulta);
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada"));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataHora(dto.getDataHora());

        consultaRepository.save(consulta);
        return ConsultaResponseDTO.fromEntity(consulta);
    }

    public void deletar(Long id) {
        consultaRepository.deleteById(id);
    }

    private Consulta toEntity(ConsultaRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataHora(dto.getDataHora());

        return consulta;
    }
}
