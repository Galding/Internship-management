package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EtudiantEntity;
import com.example.gestiondestage.entities.StudentWithTeacherAndCompanyName;
import com.example.gestiondestage.repository.StudentRepository;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;

    private final SessionFactory sessionFactory;

    public StudentService(final EntityManagerFactory factory) {
        sessionFactory = factory.unwrap(SessionFactory.class);
    }


    @Override
    public List<String> getStudentsNames() {
        return studentRepository.findAllStudentsNames();
    }

    @Override
    public List<EtudiantEntity> getAllStudents() {
        return studentRepository.findAllStudents();
    }

    @Override
    public EtudiantEntity getStudentById(final int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void removeStudent(final int id) {
        studentRepository.removeById(id);
    }

    @Override
    public int getLastAvailableId() {
        return studentRepository.findLastAvailableId();
    }

    @Override
    public void updateStudent(final EtudiantEntity student) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        session.merge(student);
        tx.commit();
        session.close();
    }

    @Override
    public void addStudent(final EtudiantEntity student) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }

    @Override
    public List<StudentWithTeacherAndCompanyName> getAllStageStudents() {
        return studentRepository.findAllStageStudents();
    }

    @Override
    public boolean login(final String login, final String mdp) {
        return studentRepository.login(login, mdp);
    }
}
