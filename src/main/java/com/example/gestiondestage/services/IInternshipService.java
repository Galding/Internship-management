package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EtudiantEntity;
import com.example.gestiondestage.entities.StageEntity;

import java.util.List;

public interface IInternshipService {

    List<StageEntity> getAllInternshipFromCompanyId(int companyId);

    EtudiantEntity getStudentNameForAnInternshipFromCompanyId(int companyId);

    StageEntity getInternshipFromStudendId(int studentId);
}
