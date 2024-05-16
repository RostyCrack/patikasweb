package com.example.proyecto_arqui;

import com.example.proyecto_arqui.entities.HistoriaMedica;
import com.example.proyecto_arqui.entities.HistoriaMedicaRepository;
import com.example.proyecto_arqui.entities.Mascota;
import com.example.proyecto_arqui.entities.MascotaRepository;
import com.example.proyecto_arqui.exceptions.HistoriaMedicaNotFoundException;
import com.example.proyecto_arqui.exceptions.MascotaNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HistoriaMedicaService {
    private final HistoriaMedicaRepository repository;
    private final MascotaRepository mascotaRepository;

    HistoriaMedicaService(HistoriaMedicaRepository repository, MascotaRepository mascotaRepository) {
        this.repository = repository;
        this.mascotaRepository = mascotaRepository;
    }

    public HistoriaMedica createHistoriaMedica(HistoriaMedica historiaMedica) {
        return repository.save(historiaMedica);
    }

    public List<HistoriaMedica> getHistoriaMedicaByIdMascota(int id) {

        log.info("Obteniendo historia medica por id mascota {}", id);
        Optional<Mascota> mascotaOptional = mascotaRepository.findByIdMascota(id);

        if (mascotaOptional.isEmpty()){
            log.error("Mascota no encontrada");
            throw new MascotaNotFoundException(id);
        }

        log.info("buscando historia medica por mascota {}", mascotaOptional.get().getNombre());
        List<HistoriaMedica> historias = repository.findDistinctByMascota(mascotaOptional.get());
        if (historias.isEmpty()){
            log.error("Historia medica no encontrada");
            throw new HistoriaMedicaNotFoundException(id);
        }else {
            return historias;
        }
    }

    public void deleteHistoriaMedica(Integer id) {
        repository.deleteById(id);
    }
}
