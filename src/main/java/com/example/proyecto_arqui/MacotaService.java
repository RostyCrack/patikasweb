package com.example.proyecto_arqui;


import com.example.proyecto_arqui.entities.Mascota;
import com.example.proyecto_arqui.entities.MascotaRepository;
import com.example.proyecto_arqui.entities.Persona;
import com.example.proyecto_arqui.entities.PersonaRepository;
import com.example.proyecto_arqui.exceptions.MascotaNotFoundException;
import com.example.proyecto_arqui.exceptions.PersonNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MacotaService {

    final MascotaRepository mascotaRepository;
    final PersonaRepository personaRepository;

    public MacotaService(MascotaRepository mascotaRepository, PersonaRepository personaRepository){
        this.mascotaRepository = mascotaRepository;
        this.personaRepository = personaRepository;
    }


    public void crearMascota(Mascota M){
        mascotaRepository.save(M);
        log.info("Creando mascota");
    }

    public void actualizarMascota(){
        log.info("Actualizando mascota");
    }

    public void eliminarMascota(){
        log.info("Eliminando mascota");
    }

    public List<Mascota> getMascotas(String username){
        log.info("Obteniendo mascota");
        Optional<Persona> persona = personaRepository.findByIdPersona(username);
        if (persona.isEmpty()){
            log.error("Persona no encontrada");
            throw new PersonNotFoundException("Persona no encontrada");
        }
        log.info("Persona: {}", persona.get().getNombre());
        return mascotaRepository.findDistinctByPersona(persona.get());
    }

    public Mascota findMascota(int id){
        log.info("Obteniendo mascota por id {}", id);
        return mascotaRepository.findById(id).orElseThrow(() -> new MascotaNotFoundException(id));
    }

    public List<Mascota> getAllMascotas(){
        log.info("Obteniendo todas las mascotas");
        return mascotaRepository.findAll();
    }

    public Mascota MascotaFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try 
        {
            return mapper.readValue(json, Mascota.class);
        } 
        catch (Exception e) {

            log.error("Error al convertir a Mascota", e);
            throw new RuntimeException("Error al sacar");

        }
    }



}
