package com.example.proyecto_arqui.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "MASCOTAS")
@Getter
@Setter
public class Mascota {


    @Column(name = "nombre")
    private String nombre;

    @Column(name = "raza")
    private String raza;

    @Id
    @Column(name = "id_mascota")
    private int idMascota;


    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    @Column(name = "edad")
    private int edad;


}
