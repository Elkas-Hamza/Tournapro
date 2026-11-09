package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Classement {

    private String tournoiId;
    private final List<String> lignes;
    private LocalDate dateCalcul;
    private boolean termine;

    public Classement() {
        this.lignes = new ArrayList<>();
    }

    public Classement(String tournoiId, List<String> lignes,
                      LocalDate dateCalcul, boolean termine) {
        this.tournoiId = tournoiId;
        this.lignes = new ArrayList<>();
        if (lignes != null) {
            for (String ligne : lignes) {
                if (ligne != null && !ligne.isBlank()) {
                    this.lignes.add(ligne.trim());
                }
            }
        }
        this.dateCalcul = dateCalcul;
        this.termine = termine;
    }

    public String getTournoiId() {
        return tournoiId;
    }

    public void setTournoiId(String tournoiId) {
        this.tournoiId = tournoiId;
    }

    public List<String> getLignes() {
        return Collections.unmodifiableList(lignes);
    }

    public LocalDate getDateCalcul() {
        return dateCalcul;
    }

    public void setDateCalcul(LocalDate dateCalcul) {
        this.dateCalcul = dateCalcul;
    }

    public boolean isTermine() {
        return termine;
    }

    public void setTermine(boolean termine) {
        this.termine = termine;
    }

    @Override
    public String toString() {
        return "Classement{tournoiId='" + tournoiId + "', lignes=" + lignes + "}";
    }
}
