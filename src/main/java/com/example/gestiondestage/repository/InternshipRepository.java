package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.LinkedStudentInternship;
import com.example.gestiondestage.entities.StageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternshipRepository extends JpaRepository<StageEntity, Integer> {

    @Query("SELECT e FROM StageEntity e WHERE e.numEntreprise = :numEntreprise")
    List<StageEntity> findAllInternshipFromACompanyId(int numEntreprise);

    @Query("SELECT new com.example.gestiondestage.entities.LinkedStudentInternship(e, s) from StageEntity s JOIN EtudiantEntity e ON s.numEtudiant=e.numEtudiant WHERE s.numEntreprise = :numEntreprise")
    List<LinkedStudentInternship> findAllStudentsFromCompanyId(int numEntreprise);

    @Query("SELECT s FROM StageEntity s WHERE s.numEtudiant = :studentId")
    StageEntity findInternshipFromStudentId(int studentId);

    @Query("SELECT max(e.numStage) FROM StageEntity e")
    int findLastInsertedId();

}
