package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EtudiantEntity;
import com.example.gestiondestage.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;

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
}
