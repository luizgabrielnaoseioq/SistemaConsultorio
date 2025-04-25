package com.nazax.sistema_consultorio.services.Consulta.Mappers;

import com.nazax.sistema_consultorio.dtos.consulta.ConsultaRequestDTO;
import com.nazax.sistema_consultorio.models.Consulta;
import com.nazax.sistema_consultorio.models.Medico;
import com.nazax.sistema_consultorio.models.Paciente;
import com.nazax.sistema_consultorio.repositories.ConsultaRepository;
import com.nazax.sistema_consultorio.repositories.MedicoRepository;
import com.nazax.sistema_consultorio.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaMapper {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta toEntity(ConsultaRequestDTO dto) {
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

    public ConsultaRequestDTO toDTO(Consulta consulta) {
        ConsultaRequestDTO dto = new ConsultaRequestDTO();
        dto.setPacienteId(consulta.getPaciente().getId());
        dto.setMedicoId(consulta.getMedico().getId());
        dto.setDataHora(consulta.getDataHora());
        dto.setObservacoes(consulta.getObservacoes());
        return dto;
    }
}
