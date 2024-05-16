package com.example.proyecto_arqui.exceptions;

public class HistoriaMedicaNotFoundException extends RuntimeException  {
    public HistoriaMedicaNotFoundException(Integer id) {
        super("Could not find historia medica for mascota with id " + id);
    }
}
