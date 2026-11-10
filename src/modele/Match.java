package modele;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Représente un match entre deux participants.
 */
public class Match  {

    private String id;
    private String tournoiId;
    private int tour;
    private int position;
    private Participant participant1;
    private Participant participant2;
    private int score1;
    private int score2;
    private boolean termine;
    private LocalDate datePrevue;

    public Match() {
    }

    public Match(String id, String tournoiId, int tour, int position,
                 Participant participant1, Participant participant2,
                 LocalDate datePrevue) {
        this.id = id;
        this.tournoiId = tournoiId;
        this.tour = tour;
        this.position = position;
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.datePrevue = datePrevue;
    }

    /**
     * Indique si les deux participants sont connus et si le match reste à jouer.
     */
    public boolean estPrete() {
        return participant1 != null && participant2 != null && !termine;
    }

    /**
     * Enregistre le résultat du match.
     *
     * @param score1 score du participant 1, entre 0 et 999
     * @param score2 score du participant 2, entre 0 et 999
     */
    public void enregistrerResultat(int score1, int score2) {
        if (!estPrete()) {
            throw new IllegalStateException(
                    "Le match n'est pas prêt à recevoir un résultat.");
        }
        validerScore(score1);
        validerScore(score2);
        this.score1 = score1;
        this.score2 = score2;
        this.termine = true;
    }

    /**
     * Corrige le résultat d'un match déjà terminé.
     */
    public void corrigerResultat(int score1, int score2) {
        if (!termine) {
            throw new IllegalStateException(
                    "Seul un match terminé peut être corrigé.");
        }
        validerScore(score1);
        validerScore(score2);
        this.score1 = score1;
        this.score2 = score2;
    }

    /**
     * Remet le match à jouer et efface le score.
     */
    public void reinitialiser() {
        this.score1 = 0;
        this.score2 = 0;
        this.termine = false;
    }

    /**
     * Retourne le participant vainqueur, ou null si le match n'est pas
     * terminé ou s'il est nul.
     */
    public Participant getVainqueur() {
        if (!termine || score1 == score2) {
            return null;
        }
        return score1 > score2 ? participant1 : participant2;
    }

    /**
     * Retourne le participant perdant, ou null si le match n'est pas terminé
     * ou s'il est nul.
     */
    public Participant getPerdant() {
        Participant vainqueur = getVainqueur();
        if (vainqueur == null) {
            return null;
        }
        return vainqueur == participant1 ? participant2 : participant1;
    }

    public boolean estNul() {
        return termine && score1 == score2;
    }

    public boolean estTermine() {
        return termine;
    }

    /**
     * Retourne « - » si le match n'est pas joué, sinon « 3 - 1 ».
     */
    public String getScoreAffichage() {
        return termine ? score1 + " - " + score2 : "-";
    }

    public String getNomParticipant1() {
        return nomParticipant(participant1);
    }

    public String getNomParticipant2() {
        return nomParticipant(participant2);
    }

    private static String nomParticipant(Participant participant) {
        return participant == null ? "En attente" : participant.getNomAffichage();
    }

    private static void validerScore(int score) {
        if (score < 0 || score > 999) {
            throw new IllegalArgumentException(
                    "Le score doit être compris entre 0 et 999.");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTournoiId() {
        return tournoiId;
    }

    public void setTournoiId(String tournoiId) {
        this.tournoiId = tournoiId;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Participant getParticipant1() {
        return participant1;
    }

    public void setParticipant1(Participant participant1) {
        this.participant1 = participant1;
    }

    public Participant getParticipant2() {
        return participant2;
    }

    public void setParticipant2(Participant participant2) {
        this.participant2 = participant2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public LocalDate getDatePrevue() {
        return datePrevue;
    }

    public void setDatePrevue(LocalDate datePrevue) {
        this.datePrevue = datePrevue;
    }

    @Override
    public boolean equals(Object objet) {
        if (this == objet) {
            return true;
        }
        if (!(objet instanceof Match)) {
            return false;
        }
        Match autre = (Match) objet;
        return id != null && Objects.equals(id, autre.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public String toString() {
        return getNomParticipant1() + " " + getScoreAffichage()
                + " " + getNomParticipant2();
    }
}
