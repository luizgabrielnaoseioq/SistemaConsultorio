package com.nazax.sistema_consultorio.controller;

import com.nazax.sistema_consultorio.dto.paciente.PacienteRequestDTO;
import com.nazax.sistema_consultorio.dto.paciente.PacienteResponseDTO;
import com.nazax.sistema_consultorio.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public PacienteResponseDTO criar(@RequestBody @Valid PacienteRequestDTO dto) {
        return pacienteService.criar(dto);
    }

    @GetMapping
    public List<PacienteResponseDTO> listarTodos() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public PacienteResponseDTO buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PacienteResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid PacienteRequestDTO dto) {
        return pacienteService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pacienteService.deletar(id);
    }
}
