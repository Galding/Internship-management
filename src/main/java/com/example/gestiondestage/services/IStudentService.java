package com.example.gestiondestage.services;

import com.example.gestiondestage.entities.EtudiantEntity;

import java.util.List;

public interface IStudentService {
    List<String> getStudentsNames();

    List<EtudiantEntity> getAllStudents();

    EtudiantEntity getStudentById(int id);

    void removeStudent(int id);

    int getLastAvailableId();

    void updateStudent(EtudiantEntity student);

    void addStudent(EtudiantEntity student);
}
