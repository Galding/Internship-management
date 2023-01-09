package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.EntrepriseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<EntrepriseEntity, Integer> {
    @Query("SELECT raisonSociale FROM EntrepriseEntity")
    List<String> findAllCompaniesName();
    @Query("SELECT e FROM EntrepriseEntity e WHERE e.numEntreprise = :id")
    EntrepriseEntity findbyId(int id);
    @Query("SELECT e FROM EntrepriseEntity e")
    List<EntrepriseEntity> findAllCompanies();
}
