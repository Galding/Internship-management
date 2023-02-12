package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.LinkedStudentInternship;
import com.example.gestiondestage.entities.StageEntity;
import com.example.gestiondestage.repository.InternshipRepository;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService implements IInternshipService {
    @Autowired
    InternshipRepository repository;
    private final SessionFactory sessionFactory;

    @Autowired
    public InternshipService(final EntityManagerFactory factory) {
        sessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Override
    public List<StageEntity> getAllInternshipFromCompanyId(final int companyId) {
        return repository.findAllInternshipFromACompanyId(companyId);
    }

    @Override
    public List<LinkedStudentInternship> getAllLinkedStudentsForAnInternshipFromCompanyId(final int companyId) {
        return repository.findAllStudentsFromCompanyId(companyId);
    }

    @Override
    public StageEntity getInternshipFromStudendId(final int studentId) {
        return repository.findInternshipFromStudentId(studentId);
    }

    @Override
    public void addStage(final StageEntity stage) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        session.save(stage);
        tx.commit();
        session.close();
    }

    @Override
    public int getLastInsertedId() {
        return repository.findLastInsertedId();
    }
}
