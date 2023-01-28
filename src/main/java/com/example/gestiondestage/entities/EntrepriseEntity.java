package com.example.gestiondestage.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@Table(name = "entreprise", schema = "bdd_geststages")
public class EntrepriseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num_entreprise")
    private int numEntreprise;
    @Basic
    @Column(name = "raison_sociale")
    private String raisonSociale;
    @Basic
    @Column(name = "nom_contact")
    private String nomContact;
    @Basic
    @Column(name = "nom_resp")
    private String nomResp;
    @Basic
    @Column(name = "rue_entreprise")
    private String rueEntreprise;
    @Basic
    @Column(name = "cp_entreprise")
    private Integer cpEntreprise;
    @Basic
    @Column(name = "ville_entreprise")
    private String villeEntreprise;
    @Basic
    @Column(name = "tel_entreprise")
    private String telEntreprise;
    @Basic
    @Column(name = "fax_entreprise")
    private String faxEntreprise;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "observation")
    private String observation;
    @Basic
    @Column(name = "site_entreprise")
    private String siteEntreprise;
    @Basic
    @Column(name = "niveau")
    private String niveau;
    @Basic
    @Column(name = "en_activite")
    private byte enActivite;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "spec_entreprise",
            schema = "bdd_geststages",
            joinColumns = @JoinColumn(name = "num_entreprise"),
            inverseJoinColumns = @JoinColumn(name = "num_spec")
    )
    private Set<SpecialiteEntity> specialites = new HashSet<>();

    public EntrepriseEntity() {

    }

    public void setSpecialites(final Set<SpecialiteEntity> specialites) {
        this.specialites = specialites;
    }

    public Set<SpecialiteEntity> getSpecialites() {
        return specialites;
    }

    public int getNumEntreprise() {
        return numEntreprise;
    }

    public void setNumEntreprise(final int numEntreprise) {
        this.numEntreprise = numEntreprise;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(final String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getNomContact() {
        return nomContact;
    }

    public void setNomContact(final String nomContact) {
        this.nomContact = nomContact;
    }

    public String getNomResp() {
        return nomResp;
    }

    public void setNomResp(final String nomResp) {
        this.nomResp = nomResp;
    }

    public String getRueEntreprise() {
        return rueEntreprise;
    }

    public void setRueEntreprise(final String rueEntreprise) {
        this.rueEntreprise = rueEntreprise;
    }

    public Integer getCpEntreprise() {
        return cpEntreprise;
    }

    public void setCpEntreprise(final Integer cpEntreprise) {
        this.cpEntreprise = cpEntreprise;
    }

    public String getVilleEntreprise() {
        return villeEntreprise;
    }

    public void setVilleEntreprise(final String villeEntreprise) {
        this.villeEntreprise = villeEntreprise;
    }

    public String getTelEntreprise() {
        return telEntreprise;
    }

    public void setTelEntreprise(final String telEntreprise) {
        this.telEntreprise = telEntreprise;
    }

    public String getFaxEntreprise() {
        return faxEntreprise;
    }

    public void setFaxEntreprise(final String faxEntreprise) {
        this.faxEntreprise = faxEntreprise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(final String observation) {
        this.observation = observation;
    }

    public String getSiteEntreprise() {
        return siteEntreprise;
    }

    public void setSiteEntreprise(final String siteEntreprise) {
        this.siteEntreprise = siteEntreprise;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(final String niveau) {
        this.niveau = niveau;
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
        final EntrepriseEntity that = (EntrepriseEntity) o;
        return numEntreprise == that.numEntreprise && enActivite == that.enActivite && Objects.equals(raisonSociale, that.raisonSociale) && Objects.equals(nomContact, that.nomContact) && Objects.equals(nomResp, that.nomResp) && Objects.equals(rueEntreprise, that.rueEntreprise) && Objects.equals(cpEntreprise, that.cpEntreprise) && Objects.equals(villeEntreprise, that.villeEntreprise) && Objects.equals(telEntreprise, that.telEntreprise) && Objects.equals(faxEntreprise, that.faxEntreprise) && Objects.equals(email, that.email) && Objects.equals(observation, that.observation) && Objects.equals(siteEntreprise, that.siteEntreprise) && Objects.equals(niveau, that.niveau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEntreprise, raisonSociale, nomContact, nomResp, rueEntreprise, cpEntreprise, villeEntreprise, telEntreprise, faxEntreprise, email, observation, siteEntreprise, niveau, enActivite);
    }
}
