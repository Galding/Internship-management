package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EtudiantEntity;
import com.example.gestiondestage.entities.StageEntity;
import com.example.gestiondestage.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService implements IInternshipService{
    @Autowired
    InternshipRepository repository;


    @Override
    public List<StageEntity> getAllInternshipFromCompanyId(int companyId) {
        return repository.findAllInternshipFromACompanyId(companyId);
    }

    @Override
    public EtudiantEntity getStudentNameForAnInternshipFromCompanyId(int companyId) {
        return repository.findStudentNameFromCompanyId(companyId);
    }
}
