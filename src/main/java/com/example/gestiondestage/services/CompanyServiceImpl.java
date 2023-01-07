package com.example.gestiondestage.services;

import com.example.gestiondestage.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;

    @Override
    public List<String> getCompaniesNames() {
        return companyRepository.findAllCompaniesName();
    }
}
