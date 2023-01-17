package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.EntrepriseEntity;
import com.example.gestiondestage.entities.SpecialiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface CompanyRepository extends JpaRepository<EntrepriseEntity, Integer> {
    @Transactional
    @Modifying
    @Query("""
            update EntrepriseEntity e set e.numEntreprise = ?1, e.raisonSociale = ?2, e.nomContact = ?3, e.nomResp = ?4, e.rueEntreprise = ?5, e.cpEntreprise = ?6, e.villeEntreprise = ?7, e.telEntreprise = ?8, e.faxEntreprise = ?9, e.email = ?10, e.observation = ?11, e.siteEntreprise = ?12, e.niveau = ?13, e.enActivite = ?14, e.specialites = ?15
            where e.numEntreprise = ?1""")
    void updateCompany(int numEntreprise, String raisonSociale, String nomContact, String nomResp, String rueEntreprise, int cpEntreprise, String villeEntreprise, String telEntreprise, String faxEntreprise, String email, String observation, String siteEntreprise, String niveau, byte enActivite, Set<SpecialiteEntity> specialites);

    @Transactional
    @Modifying
    @Query("""
            update EntrepriseEntity e set e.numEntreprise = :#{#entrepriseEntity.numEntreprise}, e.raisonSociale = :#{#entrepriseEntity.raisonSociale}, e.nomContact = :#{#entrepriseEntity.nomContact},
            e.nomResp = :#{#entrepriseEntity.nomResp}, e.rueEntreprise = :#{#entrepriseEntity.rueEntreprise}, e.cpEntreprise = :#{#entrepriseEntity.cpEntreprise}, e.villeEntreprise = :#{#entrepriseEntity.villeEntreprise}, e.telEntreprise = :#{#entrepriseEntity.telEntreprise}, e.faxEntreprise = :#{#entrepriseEntity.faxEntreprise}, e.email = :#{#entrepriseEntity.email}, e.observation = :#{#entrepriseEntity.observation}, e.siteEntreprise = :#{#entrepriseEntity.siteEntreprise}, e.niveau = :#{#entrepriseEntity.niveau}, e.enActivite = :#{#entrepriseEntity.enActivite}, e.specialites = :#{#entrepriseEntity.specialites}
            where e.numEntreprise = :#{#entrepriseEntity.numEntreprise}""")
    void updateCompany(EntrepriseEntity entrepriseEntity);

    @Query("SELECT raisonSociale FROM EntrepriseEntity")
    List<String> findAllCompaniesName();
    @Query("SELECT e FROM EntrepriseEntity e")
    List<EntrepriseEntity> findAllCompanies();

    @Modifying
    @Transactional
    @Query("DELETE FROM EntrepriseEntity e WHERE e.numEntreprise = :id ")
    void removeById(int id);
    
}
