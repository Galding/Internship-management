package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.EntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<EntrepriseEntity, Integer> {

    @Query("SELECT raisonSociale FROM EntrepriseEntity")
    List<String> findAllCompaniesName();

    @Query("SELECT e FROM EntrepriseEntity e")
    List<EntrepriseEntity> findAllCompanies();

    @Modifying
    @Transactional
    @Query("DELETE FROM EntrepriseEntity e WHERE e.numEntreprise = :id ")
    void removeById(int id);

    @Query("SELECT e FROM EntrepriseEntity e JOIN StageEntity s ON e.numEntreprise=s.numEntreprise WHERE s.numEtudiant = :studentId ")
    EntrepriseEntity findCompanyFromStudentId(int studentId);

}
