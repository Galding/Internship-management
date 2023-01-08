package com.example.gestiondestage.services;

import com.example.gestiondestage.repository.StudentRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<String> getStudentsNames() {
        return studentRepository.findAllStudentsNames();
    }
}
