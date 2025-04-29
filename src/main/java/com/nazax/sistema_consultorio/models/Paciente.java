package com.nazax.sistema_consultorio.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
public class Paciente extends Usuario{

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "convenio_id")
    private Long convenioId;

    public String getCpf() {
    }
}