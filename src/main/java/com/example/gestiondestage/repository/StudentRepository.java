package com.example.gestiondestage.repository;

import com.example.gestiondestage.entities.EtudiantEntity;
import com.example.gestiondestage.entities.StudentWithTeacherAndCompanyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<EtudiantEntity, Integer> {
    @Query("SELECT nomEtudiant FROM EtudiantEntity")
    List<String> findAllStudentsNames();

    @Query("SELECT e FROM EtudiantEntity e where e.numEtudiant = :id")
    EtudiantEntity findById(int id);

    @Query("SELECT e FROM EtudiantEntity e")
    List<EtudiantEntity> findAllStudents();

    @Modifying
    @Transactional
    @Query("DELETE FROM EtudiantEntity e WHERE e.numEtudiant = :id")
    void removeById(int id);

    @Query("SELECT max(e.numEtudiant) FROM EtudiantEntity e")
    int findLastAvailableId();

    @Query("SELECT new com.example.gestiondestage.entities.StudentWithTeacherAndCompanyName(e, p.nomProf, en.raisonSociale) FROM EtudiantEntity e " +
            "LEFT JOIN StageEntity s ON e.numEtudiant=s.numEtudiant " +
            "LEFT JOIN ProfesseurEntity p ON s.numProf=p.numProf " +
            "LEFT JOIN EntrepriseEntity en ON s.numEntreprise=en.numEntreprise")
    List<StudentWithTeacherAndCompanyName> findAllStageStudents();

    @Query(value = "SELECT if( count(*)>0, 'true', 'false' ) FROM etudiant e WHERE e.login = :login AND e.mdp = :mdp", nativeQuery = true)
    boolean login(String login, String mdp);

}
