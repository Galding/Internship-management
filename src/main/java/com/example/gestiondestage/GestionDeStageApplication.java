package com.example.gestiondestage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GestionDeStageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeStageApplication.class, args);
    }

}
