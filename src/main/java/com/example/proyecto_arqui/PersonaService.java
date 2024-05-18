package com.example.proyecto_arqui;


import com.example.proyecto_arqui.entities.Persona;
import com.example.proyecto_arqui.entities.PersonaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    public void deletePersona(String id) {
        personaRepository.deleteById(id);
    }

    public Persona getPersona(String id) {
        return personaRepository.findByIdPersona(id).orElse(null);
    }

    public Persona personaFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Persona.class);
        } catch (Exception e) {
            log.error("Error al convertir el json a persona", e);
            throw new RuntimeException("Error al convertir el json a persona");
        }
    }







}
