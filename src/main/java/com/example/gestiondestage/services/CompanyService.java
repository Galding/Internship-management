package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EntrepriseEntity;
import com.example.gestiondestage.entities.SpecialiteEntity;
import com.example.gestiondestage.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    @Override
    public void removeCompanyById(int id) {
        companyRepository.removeById(id);
    }

    @Override
    public void updateCompany(EntrepriseEntity entrepriseEntity) {
        companyRepository.updateCompany(entrepriseEntity);
        // companyRepository.updateCompany(entrepriseEntity.getNumEntreprise(), entrepriseEntity.getRaisonSociale(), entrepriseEntity.getNomContact(), entrepriseEntity.getNomResp(), entrepriseEntity.getRueEntreprise(), entrepriseEntity.getCpEntreprise(), entrepriseEntity.getVilleEntreprise(), entrepriseEntity.getTelEntreprise(), entrepriseEntity.getFaxEntreprise(), entrepriseEntity.getEmail(), entrepriseEntity.getObservation(), entrepriseEntity.getSiteEntreprise(), entrepriseEntity.getNiveau(), entrepriseEntity.getEnActivite(), entrepriseEntity.getSpecialites());
    }
}
