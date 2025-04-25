package com.nazax.sistema_consultorio.repositories;

import com.nazax.sistema_consultorio.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
