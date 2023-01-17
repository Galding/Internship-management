package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.SpecEntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecEntrepriseRepository extends JpaRepository<SpecEntrepriseEntity, Integer> {

    @Query("UPDATE SpecEntrepriseEntity e SET e.numEntreprise = :numEntreprise, e.numSpec = :numSpec WHERE e.numEntreprise = :numEntreprise")
    void updateSpec(int numEntreprise, int numSpec);

}
