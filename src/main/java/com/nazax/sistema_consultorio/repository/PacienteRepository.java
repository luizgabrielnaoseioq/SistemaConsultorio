package com.nazax.sistema_consultorio.repository;

import com.nazax.sistema_consultorio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
