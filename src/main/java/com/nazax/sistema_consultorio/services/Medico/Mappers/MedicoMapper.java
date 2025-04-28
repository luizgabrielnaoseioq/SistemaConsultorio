package com.nazax.sistema_consultorio.services.Medico.Mappers;

import com.nazax.sistema_consultorio.dtos.medico.MedicoRequestDTO;
import com.nazax.sistema_consultorio.dtos.medico.MedicoResponseDTO;
import com.nazax.sistema_consultorio.models.Medico;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper {
    public Medico toEntity(MedicoRequestDTO dto) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());
        return medico;
    }

    public MedicoResponseDTO toDTO(Medico medico) {
        MedicoResponseDTO responseDTO = new MedicoResponseDTO();
        responseDTO.setId(medico.getId());
        responseDTO.setNome(medico.getNome());
        responseDTO.setCrm(medico.getCrm());
        responseDTO.setEspecialidade(medico.getEspecialidade());
        return responseDTO;
    }
}
