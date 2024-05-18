package com.example.proyecto_arqui;

import com.example.proyecto_arqui.entities.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personas")
public class PersonaController {


    private final PersonaService personaService;


    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping("/all")
    public ResponseEntity<?> getPersonas() {
        return ResponseEntity.ok(personaService.getPersonas());
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePersona(String persona) {
        try{
            personaService.savePersona(personaService.personaFromJson(persona));
            return ResponseEntity.ok("Persona guardada");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error al guardar la persona");
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deletePersona(@RequestParam String id) {
        try{
            personaService.deletePersona(id);
            return ResponseEntity.ok("Persona eliminada");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error al eliminar la persona");
        }
    }

    @GetMapping("/by-id")
    public ResponseEntity<String> getPersona(@RequestParam String id){
        try{
            return ResponseEntity.ok(personaService.getPersona(id).toString());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error al obtener la persona");
        }
    }
}

