package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EntrepriseEntity;
import com.example.gestiondestage.repository.CompanyRepository;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    private final SessionFactory sessionFactory;

    @Autowired
    public CompanyService(final EntityManagerFactory factory) {
        sessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Override
    public List<String> getCompaniesNames() {
        return companyRepository.findAllCompaniesName();
    }

    @Override
    public List<EntrepriseEntity> getAllCompanies() {
        return companyRepository.findAllCompanies();
    }

    @Override
    public EntrepriseEntity getCompanyById(final int id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find company with id : " + id));
    }

    @Override
    public void removeCompanyById(final int id) {
        companyRepository.removeById(id);
    }

    @Override
    public void updateCompany(final EntrepriseEntity entrepriseEntity) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        session.merge(entrepriseEntity);
        tx.commit();
    }

    @Override
    public EntrepriseEntity getCompanyFromStudentId(final int studentId) {
        return companyRepository.findCompanyFromStudentId(studentId);
    }
}
