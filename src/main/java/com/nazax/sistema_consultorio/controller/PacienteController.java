package com.nazax.sistema_consultorio.controller;

import com.nazax.sistema_consultorio.dto.paciente.PacienteRequestDTO;
import com.nazax.sistema_consultorio.dto.paciente.PacienteResponseDTO;
import com.nazax.sistema_consultorio.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping
    public List<PacienteResponseDTO> listarTodos() {
        return pacienteService.listarTodos();
    }

    @PostMapping
    public void salvar(@RequestBody PacienteRequestDTO dto) {
        pacienteService.salvar(dto);
    }
}