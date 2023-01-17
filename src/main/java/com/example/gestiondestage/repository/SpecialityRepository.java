package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.SpecialiteEntity;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<SpecialiteEntity, Integer> {

    @Query("SELECT e FROM SpecialiteEntity e")
    List<SpecialiteEntity> findAll();
}
