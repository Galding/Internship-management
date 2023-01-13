package com.example.gestiondestage.services;

import com.example.gestiondestage.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService implements IProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public List<String> getProfessorsNames() {
        return professorRepository.findAllProfessorsNames();
    }
}
