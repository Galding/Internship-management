package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.EntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<EntrepriseEntity, Integer> {
    @Query("SELECT raison_sociale FROM entreprise")
    List<String> findAllCompaniesName();
    EntrepriseEntity findbyId(int id);
}
