package modele;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe abstraite commune aux joueurs et aux équipes.
 *
 * <p>Elle porte l'identité, le nom et la date d'inscription communs.
 * Les sous-classes doivent fournir leur nom d'affichage et leur type.</p>
 */
public abstract class Participant implements Comparable<Participant> {

    private String id;
    private String nom;
    private LocalDate dateInscription;

    protected Participant() {
    }

    protected Participant(String id, String nom, LocalDate dateInscription) {
        this.id = id;
        this.nom = nom;
        this.dateInscription = dateInscription;
    }

    /**
     * Retourne le nom à afficher pour ce participant.
     */
    public abstract String getNomAffichage();

    /**
     * Retourne le type du participant : « INDIVIDUEL » ou « EQUIPE ».
     */
    public abstract String getType();

    @Override
    public int compareTo(Participant autre) {
        if (autre == null) {
            return 1;
        }
        String identifiant = id == null ? "" : id;
        String autreIdentifiant = autre.id == null ? "" : autre.id;
        return identifiant.compareTo(autreIdentifiant);
    }

    @Override
    public boolean equals(Object objet) {
        if (this == objet) {
            return true;
        }
        if (!(objet instanceof Participant)) {
            return false;
        }
        Participant autre = (Participant) objet;
        return id != null && Objects.equals(id, autre.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public String toString() {
        return getNomAffichage();
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

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }
}
