package com.example.gestiondestage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.example.gestiondestage.repository")
@Configuration
public class GestionDeStageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeStageApplication.class, args);
    }

}
