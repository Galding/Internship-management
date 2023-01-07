package com.example.gestiondestage.entities;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "classe", schema = "bdd_geststages", catalog = "")
public class ClasseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_classe")
    private int numClasse;
    @Basic
    @Column(name = "nom_classe")
    private String nomClasse;

    public int getNumClasse() {
        return numClasse;
    }

    public void setNumClasse(int numClasse) {
        this.numClasse = numClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClasseEntity that = (ClasseEntity) o;
        return numClasse == that.numClasse && Objects.equals(nomClasse, that.nomClasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numClasse, nomClasse);
    }
}
