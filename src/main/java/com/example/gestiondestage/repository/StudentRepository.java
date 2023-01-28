package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.EtudiantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<EtudiantEntity, Integer> {
    @Query("SELECT nomEtudiant FROM EtudiantEntity")
    List<String> findAllStudentsNames();

    @Query("SELECT e FROM EtudiantEntity e where e.numEtudiant = :id")
    EtudiantEntity findById(int id);

    @Query("SELECT e FROM EtudiantEntity e")
    List<EtudiantEntity> findAllStudents();
}
