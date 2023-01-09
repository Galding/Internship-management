package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EntrepriseEntity;

import java.util.List;

public interface CompanyService {
    List<String> getCompaniesNames();
    List<EntrepriseEntity> getAllCompanies();
}
