package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.ProfesseurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfesseurEntity, Integer> {
    List<String> findAllProfessorsNames();
    ProfesseurEntity findByid(int id);
}
