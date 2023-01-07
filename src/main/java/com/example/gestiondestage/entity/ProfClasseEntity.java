package com.example.gestiondestage.entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "prof_classe", schema = "bdd_geststages", catalog = "")
@IdClass(ProfClasseEntityPK.class)
public class ProfClasseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_prof")
    private int numProf;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_classe")
    private int numClasse;
    @Basic
    @Column(name = "est_prof_principal")
    private byte estProfPrincipal;

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

    public byte getEstProfPrincipal() {
        return estProfPrincipal;
    }

    public void setEstProfPrincipal(byte estProfPrincipal) {
        this.estProfPrincipal = estProfPrincipal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfClasseEntity that = (ProfClasseEntity) o;
        return numProf == that.numProf && numClasse == that.numClasse && estProfPrincipal == that.estProfPrincipal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numProf, numClasse, estProfPrincipal);
    }
}
