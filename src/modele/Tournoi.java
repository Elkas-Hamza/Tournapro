package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Contient les informations et le détail d'un tournoi.
 */
public class Tournoi {

    private String id;
    private String nom;
    private String discipline;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int capaciteMax;
    private StatutTournoi statut;
    private List<Participant> participants;
    private List<Match> matchs;

    public Tournoi() {
        this.participants = new ArrayList<>();
        this.matchs = new ArrayList<>();
        this.statut = StatutTournoi.EN_ATTENTE;
    }

    public Tournoi(String id, String nom, String discipline,
                   LocalDate dateDebut, LocalDate dateFin, int capaciteMax,
                   StatutTournoi statut, List<Participant> participants,
                   List<Match> matchs) {
        this.id = id;
        this.nom = nom;
        this.discipline = discipline;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.capaciteMax = capaciteMax;
        this.statut = statut;
        this.participants = participants == null
                ? new ArrayList<>() : new ArrayList<>(participants);
        this.matchs = matchs == null ? new ArrayList<>() : new ArrayList<>(matchs);
    }

    public void ajouterParticipant(Participant participant) {
        throw new UnsupportedOperationException("TODO");
    }

    public void retirerParticipant(Participant participant) {
        throw new UnsupportedOperationException("TODO");
    }

    public void ajouterMatch(Match match) {
        throw new UnsupportedOperationException("TODO");
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<Match> getMatchs() {
        return matchs;
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

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public StatutTournoi getStatut() {
        return statut;
    }

    public void setStatut(StatutTournoi statut) {
        this.statut = statut;
    }
}
