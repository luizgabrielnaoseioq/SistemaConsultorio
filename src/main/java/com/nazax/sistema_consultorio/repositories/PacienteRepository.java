package com.nazax.sistema_consultorio.repositories;

import com.nazax.sistema_consultorio.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
