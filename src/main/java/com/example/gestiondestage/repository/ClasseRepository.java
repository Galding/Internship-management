package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.ClasseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<ClasseEntity, Integer> {

    @Query("SELECT e FROM ClasseEntity e")
    List<ClasseEntity> findAll();
}
