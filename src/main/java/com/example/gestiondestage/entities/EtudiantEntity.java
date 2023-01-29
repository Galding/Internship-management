package com.example.gestiondestage.entities;

import javax.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "etudiant", schema = "bdd_geststages", catalog = "")
public class EtudiantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_etudiant", insertable = false, updatable = false)
    private int numEtudiant;
    @Basic
    @Column(name = "nom_etudiant")
    private String nomEtudiant;
    @Basic
    @Column(name = "prenom_etudiant")
    private String prenomEtudiant;
    @Basic
    @Column(name = "annee_obtention")
    private Date anneeObtention;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "mdp")
    private String mdp;
    @Basic
    @Column(name = "num_classe")
    private int numClasse;
    @Basic
    @Column(name = "en_activite")
    private byte enActivite;

    @OneToOne
    @JoinColumn(name = "num_etudiant")
    private StageEntity stageEntity;

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(final int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(final String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(final String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public Date getAnneeObtention() {
        return anneeObtention;
    }

    public void setAnneeObtention(final Date anneeObtention) {
        this.anneeObtention = anneeObtention;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(final String mdp) {
        this.mdp = mdp;
    }

    public int getNumClasse() {
        return numClasse;
    }

    public void setNumClasse(final int numClasse) {
        this.numClasse = numClasse;
    }

    public byte getEnActivite() {
        return enActivite;
    }

    public void setEnActivite(final byte enActivite) {
        this.enActivite = enActivite;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final EtudiantEntity that = (EtudiantEntity) o;
        return numEtudiant == that.numEtudiant && numClasse == that.numClasse && enActivite == that.enActivite && Objects.equals(nomEtudiant, that.nomEtudiant) && Objects.equals(prenomEtudiant, that.prenomEtudiant) && Objects.equals(anneeObtention, that.anneeObtention) && Objects.equals(login, that.login) && Objects.equals(mdp, that.mdp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEtudiant, nomEtudiant, prenomEtudiant, anneeObtention, login, mdp, numClasse, enActivite);
    }
}
