package com.example.proyecto_arqui.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "PERSONAS")
@Getter
@Setter
public class Persona {


    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Id
    @Column(name = "id_persona")
    private String idPersona;

    @Column(name = "veterinario")
    private boolean veterinario;




}
