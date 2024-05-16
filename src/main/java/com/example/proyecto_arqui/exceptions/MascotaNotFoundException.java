package com.example.proyecto_arqui.exceptions;

public class MascotaNotFoundException extends RuntimeException{
    public MascotaNotFoundException(Integer id) {
        super("Could not find mascota " + id);
    }
}
