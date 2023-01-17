package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.SpecialiteEntity;
import com.example.gestiondestage.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService implements ISpecialityService{

    @Autowired
    SpecialityRepository specialityRepository;
    @Override
    public List<SpecialiteEntity> getAllSpeciality() {
        return specialityRepository.findAll();
    }
}
