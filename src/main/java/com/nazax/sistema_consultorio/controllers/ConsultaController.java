package com.nazax.sistema_consultorio.controllers;

import com.nazax.sistema_consultorio.dtos.consulta.ConsultaRequestDTO;
import com.nazax.sistema_consultorio.dtos.consulta.ConsultaResponseDTO;
import com.nazax.sistema_consultorio.services.Consulta.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public ConsultaResponseDTO criar(@RequestBody @Valid ConsultaRequestDTO dto) {
        return consultaService.save(dto);
    }

    @GetMapping
    public List<ConsultaResponseDTO> listarTodos() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public ConsultaResponseDTO buscarPorId(@PathVariable Long id) {
        return consultaService.findById(id);
    }

    @PutMapping("/{id}")
    public ConsultaResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDTO dto) {
        return consultaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        consultaService.delete(id);
    }
}
