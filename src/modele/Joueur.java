package modele;

import java.time.LocalDate;

/**
 * Représente un joueur, participant individuel.
 */
public class Joueur extends Participant {

    private String prenom;
    private String pseudo;
    private LocalDate dateNaissance;

    public Joueur() {
        super();
    }

    public Joueur(String id, String nom, String prenom, String pseudo,
                  LocalDate dateNaissance, LocalDate dateInscription) {
        super(id, nom, dateInscription);
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.dateNaissance = dateNaissance;
    }

    /**
     * Retourne le nom affichable du joueur, par exemple
     * « alice (Alice A) ».
     */
    @Override
    public String getNomAffichage() {
        String identite = ((getNom() == null ? "" : getNom().trim()) + " "
                + (prenom == null ? "" : prenom.trim())).trim();
        if (pseudo == null || pseudo.isBlank()) {
            return identite;
        }
        String valeurPseudo = pseudo.trim();
        return identite.isEmpty()
                ? valeurPseudo
                : valeurPseudo + " (" + identite + ")";
    }

    @Override
    public String getType() {
        return "INDIVIDUEL";
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
}
