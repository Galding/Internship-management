package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.ClasseEntity;
import com.example.gestiondestage.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService implements IClasseService {

    @Autowired
    private ClasseRepository repository;

    @Override
    public List<ClasseEntity> getAllClasses() {
        return repository.findAll();
    }
}
