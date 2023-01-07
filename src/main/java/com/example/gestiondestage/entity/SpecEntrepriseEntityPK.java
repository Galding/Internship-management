package com.example.gestiondestage.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class SpecEntrepriseEntityPK implements Serializable {
    @Column(name = "num_entreprise")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numEntreprise;
    @Column(name = "num_spec")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numSpec;

    public int getNumEntreprise() {
        return numEntreprise;
    }

    public void setNumEntreprise(int numEntreprise) {
        this.numEntreprise = numEntreprise;
    }

    public int getNumSpec() {
        return numSpec;
    }

    public void setNumSpec(int numSpec) {
        this.numSpec = numSpec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecEntrepriseEntityPK that = (SpecEntrepriseEntityPK) o;
        return numEntreprise == that.numEntreprise && numSpec == that.numSpec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEntreprise, numSpec);
    }
}
