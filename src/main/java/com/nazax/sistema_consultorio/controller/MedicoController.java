package com.nazax.sistema_consultorio.controller;

import com.nazax.sistema_consultorio.dto.medico.MedicoRequestDTO;
import com.nazax.sistema_consultorio.dto.medico.MedicoResponseDTO;
import com.nazax.sistema_consultorio.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping
    public List<MedicoResponseDTO> listarTodos() {
        return medicoService.listarTodos();
    }

    @PostMapping
    public void salvar(@RequestBody MedicoRequestDTO dto) {
        medicoService.salvar(dto);
    }
}
