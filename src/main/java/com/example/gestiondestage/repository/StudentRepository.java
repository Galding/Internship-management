package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.EtudiantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<EtudiantEntity, Integer> {
    @Query("SELECT nom_etudiant FROM etudiant")
    List<String> findAllStudentsNames();
    EtudiantEntity findById(int id);
}
