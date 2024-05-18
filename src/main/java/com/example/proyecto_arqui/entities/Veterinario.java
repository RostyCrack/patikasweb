package com.example.proyecto_arqui.entities;


import jakarta.persistence.*;

@Table(name = "VETERINARIOS")
@Entity
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinario")
    private String idVeterinario;


    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;


}
