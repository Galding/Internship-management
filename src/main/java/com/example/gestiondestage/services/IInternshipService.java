package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.StageEntity;

import java.util.List;

public interface IInternshipService {

    List<StageEntity> getAllInternshipFromCompanyNumber(int companyNumber);
}
