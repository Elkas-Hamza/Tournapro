package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Représente une équipe, participant collectif.
 */
public class Equipe extends Participant {

    private String code;
    private String capitaine;
    private final List<String> membres;

    public Equipe() {
        super();
        this.membres = new ArrayList<>();
    }

    public Equipe(String id, String nom, String code, String capitaine,
                  LocalDate dateInscription, List<String> membres) {
        super(id, nom, dateInscription);
        this.code = code;
        this.capitaine = capitaine;
        this.membres = new ArrayList<>();
        if (membres != null) {
            for (String membre : membres) {
                if (membre == null || membre.isBlank()) {
                    continue;
                }
                String valeur = membre.trim();
                if (!this.membres.contains(valeur)) {
                    this.membres.add(valeur);
                }
            }
        }
    }

    /**
     * Retourne le nom affichable de l'équipe, par exemple « Tigres [TIG] ».
     */
    @Override
    public String getNomAffichage() {
        String base = getNom() == null ? "" : getNom().trim();
        if (code == null || code.isBlank()) {
            return base;
        }
        return base + " [" + code.trim() + "]";
    }

    @Override
    public String getType() {
        return "EQUIPE";
    }

    public void ajouterMembre(String membre) {
        if (membre == null || membre.isBlank()) {
            return;
        }
        String valeur = membre.trim();
        if (!membres.contains(valeur)) {
            membres.add(valeur);
        }
    }

    public boolean retirerMembre(String membre) {
        if (membre == null) {
            return false;
        }
        return membres.remove(membre.trim());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCapitaine() {
        return capitaine;
    }

    public void setCapitaine(String capitaine) {
        this.capitaine = capitaine;
    }

    public List<String> getMembres() {
        return Collections.unmodifiableList(membres);
    }
}
