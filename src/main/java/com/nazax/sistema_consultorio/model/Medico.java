package com.nazax.sistema_consultorio.model;

import com.nazax.sistema_consultorio.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
}
