package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.ProfesseurEntity;

import java.util.List;

public interface IProfessorService {
    List<String> getProfessorsNames();

    List<ProfesseurEntity> getAllProfessors();

}
