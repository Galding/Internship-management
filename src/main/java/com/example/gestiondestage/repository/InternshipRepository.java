package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.StageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternshipRepository extends JpaRepository<StageEntity, Integer> {

    @Query("SELECT e FROM StageEntity e WHERE e.numEntreprise = :numEntreprise")
    List<StageEntity> findAllInternshipFromACompanyId(int numEntreprise);

}
