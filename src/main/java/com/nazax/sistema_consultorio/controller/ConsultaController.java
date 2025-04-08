package com.nazax.sistema_consultorio.controller;

import com.nazax.sistema_consultorio.dto.consulta.ConsultaRequestDTO;
import com.nazax.sistema_consultorio.dto.consulta.ConsultaResponseDTO;
import com.nazax.sistema_consultorio.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping
    public List<ConsultaResponseDTO> listarTodos() {
        return consultaService.listarTodos();
    }

    @PostMapping
    public void salvar(@RequestBody ConsultaRequestDTO dto) {
        consultaService.salvar(dto);
    }
}

