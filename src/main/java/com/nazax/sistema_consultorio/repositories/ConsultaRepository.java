package com.nazax.sistema_consultorio.repositories;

import com.nazax.sistema_consultorio.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
