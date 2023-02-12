package com.example.gestiondestage.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "stage", schema = "bdd_geststages")
@AllArgsConstructor
public class StageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_stage")
    private int numStage;
    @Basic
    @Column(name = "debut_stage")
    private Date debutStage;
    @Basic
    @Column(name = "fin_stage")
    private Date finStage;
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
    
    public StageEntity() {

    }

    public int getNumStage() {
        return numStage;
    }

    public void setNumStage(final int numStage) {
        this.numStage = numStage;
    }

    public Date getDebutStage() {
        return debutStage;
    }

    public void setDebutStage(final Date debutStage) {
        this.debutStage = debutStage;
    }

    public Date getFinStage() {
        return finStage;
    }

    public void setFinStage(final Date finStage) {
        this.finStage = finStage;
    }

    public String getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(final String typeStage) {
        this.typeStage = typeStage;
    }

    public String getDescProjet() {
        return descProjet;
    }

    public void setDescProjet(final String descProjet) {
        this.descProjet = descProjet;
    }

    public String getObservationStage() {
        return observationStage;
    }

    public void setObservationStage(final String observationStage) {
        this.observationStage = observationStage;
    }

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(final int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public int getNumProf() {
        return numProf;
    }

    public void setNumProf(final int numProf) {
        this.numProf = numProf;
    }

    public int getNumEntreprise() {
        return numEntreprise;
    }

    public void setNumEntreprise(final int numEntreprise) {
        this.numEntreprise = numEntreprise;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final StageEntity that = (StageEntity) o;
        return numStage == that.numStage && numEtudiant == that.numEtudiant && numProf == that.numProf && numEntreprise == that.numEntreprise && Objects.equals(debutStage, that.debutStage) && Objects.equals(finStage, that.finStage) && Objects.equals(typeStage, that.typeStage) && Objects.equals(descProjet, that.descProjet) && Objects.equals(observationStage, that.observationStage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numStage, debutStage, finStage, typeStage, descProjet, observationStage, numEtudiant, numProf, numEntreprise);
    }
}
