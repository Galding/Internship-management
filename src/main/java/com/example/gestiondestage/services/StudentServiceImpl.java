package com.example.gestiondestage.services;

import com.example.gestiondestage.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    StudentRepository studentRepository;

    @Override
    public List<String> getAllStudentsNames() {
        return studentRepository.findAllStudentsNames();
    }
}
