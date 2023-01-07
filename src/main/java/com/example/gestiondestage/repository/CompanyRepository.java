package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.EntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<EntrepriseEntity, String> {
    @Query("SELECT raison_sociale FROM entreprise")
    List<String> findAllCompaniesName();
}
