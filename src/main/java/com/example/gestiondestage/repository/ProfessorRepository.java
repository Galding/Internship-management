package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.ProfesseurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfesseurEntity, Integer> {
    @Query("SELECT nomProf FROM ProfesseurEntity")
    List<String> findAllProfessorsNames();

    @Query("SELECT p from ProfesseurEntity p WHERE p.numProf = :id")
    ProfesseurEntity findByid(int id);

    @Query("SELECT e FROM ProfesseurEntity e")
    List<ProfesseurEntity> findAll();

    @Query(value = "SELECT if( e.num_prof is not null, 'true', 'false' ) FROM professeur as e WHERE e.login = :login AND e.mdp = :mdp", nativeQuery = true)
    boolean login(String login, String mdp);
}
