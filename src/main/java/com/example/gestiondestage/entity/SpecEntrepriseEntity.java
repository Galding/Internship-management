package com.example.gestiondestage.entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "spec_entreprise", schema = "bdd_geststages", catalog = "")
@IdClass(SpecEntrepriseEntityPK.class)
public class SpecEntrepriseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_entreprise")
    private int numEntreprise;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_spec")
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
        SpecEntrepriseEntity that = (SpecEntrepriseEntity) o;
        return numEntreprise == that.numEntreprise && numSpec == that.numSpec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEntreprise, numSpec);
    }
}
