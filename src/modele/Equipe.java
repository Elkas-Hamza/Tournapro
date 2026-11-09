package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Equipe {

    private String id;
    private String nom;
    private String code;
    private String capitaine;
    private LocalDate dateInscription;
    private final List<String> membres;

    public Equipe() {
        this.membres = new ArrayList<>();
    }

    public Equipe(String id, String nom, String code, String capitaine,
                  LocalDate dateInscription, List<String> membres) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.capitaine = capitaine;
        this.dateInscription = dateInscription;
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


    public String getNomAffichage() {
        String base = nom == null ? "" : nom.trim();
        if (code == null || code.isBlank()) {
            return base;
        }
        return base + " [" + code.trim() + "]";
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

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public List<String> getMembres() {
        return Collections.unmodifiableList(membres);
    }

    @Override
    public boolean equals(Object objet) {
        if (this == objet) {
            return true;
        }
        if (!(objet instanceof Equipe)) {
            return false;
        }
        Equipe autre = (Equipe) objet;
        return id != null && Objects.equals(id, autre.id);
    }


    @Override
    public String toString() {
        return getNomAffichage();
    }
}
