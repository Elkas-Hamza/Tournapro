package modele;

import java.time.LocalDate;
import java.util.Objects;


public class Joueur {

    private String id;
    private String nom;
    private String prenom;
    private String pseudo;
    private LocalDate dateNaissance;
    private LocalDate dateInscription;

    public Joueur() {
    }

    public Joueur(String id, String nom, String prenom, String pseudo,LocalDate dateNaissance, LocalDate dateInscription) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.dateNaissance = dateNaissance;
        this.dateInscription = dateInscription;
    }


    public String getNomAffichage() {
        String identite = ((nom == null ? "" : nom.trim()) + " "+ (prenom == null ? "" : prenom.trim())).trim();
            return identite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Override
    public boolean equals(Object objet) {
        if (this == objet) {
            return true;
        }
        if (!(objet instanceof Joueur)) {
            return false;
        }
        Joueur autre = (Joueur) objet;
        return id != null && Objects.equals(id, autre.id);
    }



    @Override
    public String toString() {
        return getNomAffichage();
    }
}
