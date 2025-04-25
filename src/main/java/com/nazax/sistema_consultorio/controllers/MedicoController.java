package com.nazax.sistema_consultorio.controllers;

import com.nazax.sistema_consultorio.dtos.medico.MedicoRequestDTO;
import com.nazax.sistema_consultorio.dtos.medico.MedicoResponseDTO;
import com.nazax.sistema_consultorio.services.Medico.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    public MedicoResponseDTO criar(@RequestBody @Valid MedicoRequestDTO dto) {
        return medicoService.criar(dto);
    }

    @GetMapping
    public List<MedicoResponseDTO> listarTodos() {
        return medicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public MedicoResponseDTO buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public MedicoResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid MedicoRequestDTO dto) {
        return medicoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        medicoService.deletar(id);
    }
}

