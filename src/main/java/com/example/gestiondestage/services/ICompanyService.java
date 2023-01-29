package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EntrepriseEntity;

import java.util.List;

public interface ICompanyService {
    List<String> getCompaniesNames();

    List<EntrepriseEntity> getAllCompanies();

    EntrepriseEntity getCompanyById(int id);

    void removeCompanyById(int id);

    void updateCompany(EntrepriseEntity entrepriseEntity);

    void addCompany(EntrepriseEntity entrepriseEntity);

    EntrepriseEntity getCompanyFromStudentId(int studentId);

    int getLastAvailableId();
}
