package com.nazax.sistema_consultorio.services.Consulta;

import com.nazax.sistema_consultorio.dtos.consulta.ConsultaRequestDTO;
import com.nazax.sistema_consultorio.dtos.consulta.ConsultaResponseDTO;
import com.nazax.sistema_consultorio.models.Consulta;
import com.nazax.sistema_consultorio.models.Medico;
import com.nazax.sistema_consultorio.models.Paciente;
import com.nazax.sistema_consultorio.repositories.ConsultaRepository;
import com.nazax.sistema_consultorio.repositories.MedicoRepository;
import com.nazax.sistema_consultorio.repositories.PacienteRepository;
import com.nazax.sistema_consultorio.services.Consulta.Mappers.ConsultaMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService{

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaMapper consultaMapper;

    public ConsultaResponseDTO save(ConsultaRequestDTO dto) {
        Consulta consulta = consultaMapper.toEntity(dto);
        consultaRepository.save(consulta);
        return ConsultaResponseDTO.fromEntity(consulta);
    }

    public List<ConsultaResponseDTO> findAll() {
        return consultaRepository.findAll().stream()
                .map(ConsultaResponseDTO::fromEntity)
                .toList();
    }

    public ConsultaResponseDTO findById(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada"));
        return ConsultaResponseDTO.fromEntity(consulta);
    }

    public ConsultaResponseDTO update(Long id, ConsultaRequestDTO dto) {
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

    public void delete(Long id) {
        consultaRepository.deleteById(id);
    }
}