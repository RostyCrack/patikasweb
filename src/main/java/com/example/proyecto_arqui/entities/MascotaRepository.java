package com.example.proyecto_arqui.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    List<Mascota> findDistinctByPersona(Persona idPersona);

    Optional<Mascota> findByIdMascota(Integer idMascota);
}
