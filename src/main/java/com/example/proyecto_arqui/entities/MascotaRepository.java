package com.example.proyecto_arqui.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    List<Mascota> findDistinctByPersona(Persona idPersona);

    Optional<Mascota> findByIdMascota(Integer idMascota);

    // @Transactional
    // @Modifying
    // @Query("update Mascota m set m.nombre = ?0, m.raza = ?1, m.id_persona = ?2, m.edad=?3, m.id_Mascota= 2\"")
    // Mascota addMascota(String nombre, String raza, int id_persona, int edad);
    //dejo esto por si acaso no funciona el otro
    
}
