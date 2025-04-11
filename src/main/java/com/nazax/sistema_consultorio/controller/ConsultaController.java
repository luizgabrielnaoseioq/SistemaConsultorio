package com.nazax.sistema_consultorio.controller;

import com.nazax.sistema_consultorio.dto.consulta.ConsultaRequestDTO;
import com.nazax.sistema_consultorio.dto.consulta.ConsultaResponseDTO;
import com.nazax.sistema_consultorio.service.ConsultaService;
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
        return consultaService.criar(dto);
    }

    @GetMapping
    public List<ConsultaResponseDTO> listarTodos() {
        return consultaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ConsultaResponseDTO buscarPorId(@PathVariable Long id) {
        return consultaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ConsultaResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDTO dto) {
        return consultaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        consultaService.deletar(id);
    }
}
