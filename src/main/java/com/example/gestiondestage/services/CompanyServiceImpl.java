package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EntrepriseEntity;
import com.example.gestiondestage.repository.CompanyRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

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
}
