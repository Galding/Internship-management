package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EntrepriseEntity;
import com.example.gestiondestage.repository.CompanyRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    private SessionFactory sessionFactory;

    @Autowired
    public CompanyService(EntityManagerFactory factory){
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
    public EntrepriseEntity getCompanyById(int id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find company with id : " + id));
    }

    @Override
    public void removeCompanyById(int id) {
        companyRepository.removeById(id);
    }

    // FIXME
    @Override
    @Transactional
    @Modifying
    public void updateCompany(EntrepriseEntity entrepriseEntity) {
        EntityManager em = sessionFactory.createEntityManager();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "update EntrepriseEntity e set e.numEntreprise = :numEntreprise, e.raisonSociale = :raisonSociale, e.nomContact = :nomContact, e.nomResp = :nomResp, e.rueEntreprise = :rueEntreprise, e.cpEntreprise = :cpEntreprise, e.villeEntreprise = :villeEntreprise, e.telEntreprise = :telEntreprise, e.faxEntreprise = :faxEntreprise, e.email = :email, e.observation = :observation, e.siteEntreprise = :siteEntreprise, e.niveau = :niveau, e.enActivite = :enActivite, e.specialites = :spec where e.numEntreprise = :numEntreprise";
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setParameter("numEntreprise", entrepriseEntity.getNumEntreprise());
        query.setParameter("raisonSociale", entrepriseEntity.getRaisonSociale());
        query.setParameter("nomContact", entrepriseEntity.getNomContact());
        query.setParameter("nomResp", entrepriseEntity.getNomResp());
        query.setParameter("rueEntreprise", entrepriseEntity.getRueEntreprise());
        query.setParameter("cpEntreprise", entrepriseEntity.getCpEntreprise());
        query.setParameter("villeEntreprise", entrepriseEntity.getVilleEntreprise());
        query.setParameter("telEntreprise", entrepriseEntity.getTelEntreprise());
        query.setParameter("faxEntreprise", entrepriseEntity.getFaxEntreprise());
        query.setParameter("email", entrepriseEntity.getEmail());
        query.setParameter("siteEntreprise", entrepriseEntity.getSiteEntreprise());
        query.setParameter("observation", entrepriseEntity.getObservation());
        query.setParameter("enActivite", entrepriseEntity.getEnActivite());
        query.setParameter("spec", entrepriseEntity.getSpecialites());
        query.executeUpdate();
        tx.commit();
    }
}
