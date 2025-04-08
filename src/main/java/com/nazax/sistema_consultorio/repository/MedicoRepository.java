package com.nazax.sistema_consultorio.repository;

import com.nazax.sistema_consultorio.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
