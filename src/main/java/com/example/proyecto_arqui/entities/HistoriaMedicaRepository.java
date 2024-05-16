package com.example.proyecto_arqui.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriaMedicaRepository extends JpaRepository<HistoriaMedica, Integer> {

    List<HistoriaMedica> findDistinctByMascota(Mascota mascota);

}
