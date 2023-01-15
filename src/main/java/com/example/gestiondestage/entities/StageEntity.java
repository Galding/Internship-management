package com.example.gestiondestage.entities;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stage", schema = "bdd_geststages", catalog = "")
public class StageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_stage")
    private int numStage;
    @Basic
    @Column(name = "debut_stage")
    private Timestamp debutStage;
    @Basic
    @Column(name = "fin_stage")
    private Timestamp finStage;
    @Basic
    @Column(name = "type_stage")
    private String typeStage;
    @Basic
    @Column(name = "desc_projet")
    private String descProjet;
    @Basic
    @Column(name = "observation_stage")
    private String observationStage;
    @Basic
    @Column(name = "num_etudiant")
    private int numEtudiant;
    @Basic
    @Column(name = "num_prof")
    private int numProf;
    @Basic
    @Column(name = "num_entreprise")
    private int numEntreprise;

    @OneToOne(mappedBy = "stageEntity")
    private EtudiantEntity etudiantEntity;
    public int getNumStage() {
        return numStage;
    }

    public void setNumStage(int numStage) {
        this.numStage = numStage;
    }

    public Timestamp getDebutStage() {
        return debutStage;
    }

    public void setDebutStage(Timestamp debutStage) {
        this.debutStage = debutStage;
    }

    public Timestamp getFinStage() {
        return finStage;
    }

    public void setFinStage(Timestamp finStage) {
        this.finStage = finStage;
    }

    public String getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(String typeStage) {
        this.typeStage = typeStage;
    }

    public String getDescProjet() {
        return descProjet;
    }

    public void setDescProjet(String descProjet) {
        this.descProjet = descProjet;
    }

    public String getObservationStage() {
        return observationStage;
    }

    public void setObservationStage(String observationStage) {
        this.observationStage = observationStage;
    }

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public int getNumProf() {
        return numProf;
    }

    public void setNumProf(int numProf) {
        this.numProf = numProf;
    }

    public int getNumEntreprise() {
        return numEntreprise;
    }

    public void setNumEntreprise(int numEntreprise) {
        this.numEntreprise = numEntreprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StageEntity that = (StageEntity) o;
        return numStage == that.numStage && numEtudiant == that.numEtudiant && numProf == that.numProf && numEntreprise == that.numEntreprise && Objects.equals(debutStage, that.debutStage) && Objects.equals(finStage, that.finStage) && Objects.equals(typeStage, that.typeStage) && Objects.equals(descProjet, that.descProjet) && Objects.equals(observationStage, that.observationStage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numStage, debutStage, finStage, typeStage, descProjet, observationStage, numEtudiant, numProf, numEntreprise);
    }
}
