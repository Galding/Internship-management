package com.example.gestiondestage.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class ProfClasseEntityPK implements Serializable {
    @Column(name = "num_prof")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numProf;
    @Column(name = "num_classe")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numClasse;

    public int getNumProf() {
        return numProf;
    }

    public void setNumProf(int numProf) {
        this.numProf = numProf;
    }

    public int getNumClasse() {
        return numClasse;
    }

    public void setNumClasse(int numClasse) {
        this.numClasse = numClasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfClasseEntityPK that = (ProfClasseEntityPK) o;
        return numProf == that.numProf && numClasse == that.numClasse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numProf, numClasse);
    }
}
