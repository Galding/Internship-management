package com.example.gestiondestage.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository {
    @Query("SELECT nom_etudiant FROM etudiant")
    List<String> findAllStudentsNames();
}
