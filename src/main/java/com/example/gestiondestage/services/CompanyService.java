package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EntrepriseEntity;
import com.example.gestiondestage.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<String> getCompaniesNames() {
        return companyRepository.findAllCompaniesName();
    }

    @Override
    public List<EntrepriseEntity> getAllCompanies() {
        return companyRepository.findAllCompanies();
    }

    @Override
    public EntrepriseEntity getCompanyById(int id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find company with id : " + id));
    }
}
