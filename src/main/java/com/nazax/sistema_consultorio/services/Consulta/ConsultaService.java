package com.nazax.sistema_consultorio.services.Consulta;

import com.nazax.sistema_consultorio.dtos.consulta.ConsultaRequestDTO;
import com.nazax.sistema_consultorio.dtos.consulta.ConsultaResponseDTO;
import com.nazax.sistema_consultorio.models.Consulta;
import com.nazax.sistema_consultorio.models.Medico;
import com.nazax.sistema_consultorio.models.Paciente;
import com.nazax.sistema_consultorio.repositories.ConsultaRepository;
import com.nazax.sistema_consultorio.repositories.MedicoRepository;
import com.nazax.sistema_consultorio.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultaService {

    ConsultaResponseDTO save(ConsultaRequestDTO dto);
    List<ConsultaResponseDTO> findAll();
    ConsultaResponseDTO findById(Long id);
    ConsultaResponseDTO update(Long id, ConsultaRequestDTO dto);
    void delete(Long id);
}
