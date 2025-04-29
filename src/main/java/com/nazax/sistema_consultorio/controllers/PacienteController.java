package com.nazax.sistema_consultorio.controllers;

import com.nazax.sistema_consultorio.dtos.paciente.PacienteRequestDTO;
import com.nazax.sistema_consultorio.dtos.paciente.PacienteResponseDTO;
import com.nazax.sistema_consultorio.services.PacienteService.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public PacienteResponseDTO criar(@RequestBody PacienteRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public PacienteResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<PacienteResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public PacienteResponseDTO atualizar(@PathVariable Long id, @RequestBody PacienteRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
