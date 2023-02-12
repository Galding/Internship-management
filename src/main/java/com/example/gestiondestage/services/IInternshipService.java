package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.LinkedStudentInternship;
import com.example.gestiondestage.entities.StageEntity;

import java.util.List;

public interface IInternshipService {

    List<StageEntity> getAllInternshipFromCompanyId(int companyId);

    List<LinkedStudentInternship> getAllLinkedStudentsForAnInternshipFromCompanyId(int companyId);

    StageEntity getInternshipFromStudendId(int studentId);

    void addStage(StageEntity stage);

    int getLastInsertedId();
}
