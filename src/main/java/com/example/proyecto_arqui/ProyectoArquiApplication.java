package com.example.proyecto_arqui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProyectoArquiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoArquiApplication.class, args);
    }

}
