package com.example.gestiondestage.entities;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "professeur", schema = "bdd_geststages", catalog = "")
public class ProfesseurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_prof")
    private int numProf;
    @Basic
    @Column(name = "nom_prof")
    private String nomProf;
    @Basic
    @Column(name = "prenom_prof")
    private String prenomProf;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "mdp")
    private String mdp;
    @Basic
    @Column(name = "email")
    private String email;

    public int getNumProf() {
        return numProf;
    }

    public void setNumProf(final int numProf) {
        this.numProf = numProf;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(final String nomProf) {
        this.nomProf = nomProf;
    }

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(final String prenomProf) {
        this.prenomProf = prenomProf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ProfesseurEntity that = (ProfesseurEntity) o;
        return numProf == that.numProf && Objects.equals(nomProf, that.nomProf) && Objects.equals(prenomProf, that.prenomProf) && Objects.equals(login, that.login) && Objects.equals(mdp, that.mdp) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numProf, nomProf, prenomProf, login, mdp, email);
    }
}
