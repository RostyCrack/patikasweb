package com.example.proyecto_arqui.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "historia_medica")
@Getter
@Setter
public class HistoriaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia")
    private Integer idHistoria;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_vacuna")
    private Vacuna vacuna;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
}
