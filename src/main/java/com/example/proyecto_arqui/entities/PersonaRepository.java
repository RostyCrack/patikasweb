package com.example.proyecto_arqui.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonaRepository extends JpaRepository<Persona, String> {

    Optional<Persona> findByIdPersona(String idPersona);


}
