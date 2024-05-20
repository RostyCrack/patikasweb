package com.example.proyecto_arqui;


import com.example.proyecto_arqui.exceptions.PersonNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mascotas")
@Slf4j
public class MascotaController {

    final MacotaService mascotaService;


    public MascotaController(MacotaService mascotaService){
        this.mascotaService = mascotaService;
    }


    @GetMapping("/by-username")
    public ResponseEntity<String> getMascotaUsername(@RequestParam String username){
        try{
            return ResponseEntity.ok(JsonUtil.convertObjectToJson(mascotaService.getMascotas(username)));
        }
        catch (PersonNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el id " + username);
        }

    }

    @GetMapping("/by-id")
    public ResponseEntity<String> getMascota(@RequestParam int id){
        return ResponseEntity.ok(JsonUtil.convertObjectToJson(mascotaService.findMascota(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllMascotas(){
        String jsonResult = JsonUtil.convertListToJson(mascotaService.getAllMascotas());
        log.info("jsonResult: {}", jsonResult);
        return ResponseEntity.ok(JsonUtil.convertObjectToJson(mascotaService.getAllMascotas()));
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveMascota(String Mascota) {
        try{
            mascotaService.crearMascota(mascotaService.MascotaFromJson(Mascota));
            return ResponseEntity.ok("Mascota guardada con exito");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("No se pudo crear mascota");
        }
    }


}
