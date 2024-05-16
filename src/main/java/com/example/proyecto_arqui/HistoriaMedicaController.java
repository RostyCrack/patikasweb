package com.example.proyecto_arqui;


import com.example.proyecto_arqui.entities.HistoriaMedica;
import com.example.proyecto_arqui.exceptions.MascotaNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historia-medica")
public class HistoriaMedicaController {

    private final HistoriaMedicaService historiaMedicaService;

    public HistoriaMedicaController(HistoriaMedicaService historiaMedicaService) {
        this.historiaMedicaService = historiaMedicaService;
    }

    @RequestMapping("/")
    public String historiaMedica() {
        return "historia-medica";
    }

    @RequestMapping("/{id}")
    public String historiaMedicaId() {
        return "historia-medica";
    }

    @RequestMapping("/mascota")
    public ResponseEntity<?> historiaMedicaMascotaId(@RequestParam int id) {
        try{
            return ResponseEntity.ok(historiaMedicaService.getHistoriaMedicaByIdMascota(id));
        }
        catch (MascotaNotFoundException e){
            return ResponseEntity.status(404).body("Mascota not found");
        }
    }

}
