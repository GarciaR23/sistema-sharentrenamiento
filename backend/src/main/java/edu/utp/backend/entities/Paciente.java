package edu.utp.backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "nombre_paciente", nullable = false)
    private String nombrePaciente;

    @Column(name = "condicion_diagnostico")
    private String condicionDiagnostico;

    @Column(name = "grado_autismo")
    private String gradoAutismo;

    @Column(name = "genero")
    private String genero;

    @Column(name = "edad")
    private Integer edad;
}