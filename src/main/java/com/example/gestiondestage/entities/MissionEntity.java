package com.example.gestiondestage.entities;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "mission", schema = "bdd_geststages", catalog = "")
public class MissionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_mission")
    private int numMission;
    @Basic
    @Column(name = "libelle")
    private String libelle;
    @Basic
    @Column(name = "num_stage")
    private int numStage;

    public int getNumMission() {
        return numMission;
    }

    public void setNumMission(int numMission) {
        this.numMission = numMission;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNumStage() {
        return numStage;
    }

    public void setNumStage(int numStage) {
        this.numStage = numStage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissionEntity that = (MissionEntity) o;
        return numMission == that.numMission && numStage == that.numStage && Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numMission, libelle, numStage);
    }
}
