package com.example.gestiondestage.entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "specialite", schema = "bdd_geststages", catalog = "")
public class SpecialiteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_spec")
    private int numSpec;
    @Basic
    @Column(name = "libelle")
    private String libelle;

    public int getNumSpec() {
        return numSpec;
    }

    public void setNumSpec(int numSpec) {
        this.numSpec = numSpec;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialiteEntity that = (SpecialiteEntity) o;
        return numSpec == that.numSpec && Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSpec, libelle);
    }
}
