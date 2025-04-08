package com.nazax.sistema_consultorio.repository;

import com.nazax.sistema_consultorio.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
