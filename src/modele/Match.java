package modele;

import java.time.LocalDate;
import java.util.Objects;


public class Match {

    private String id;
    private String tournoiId;
    private int tour;
    private int position;
    private Object participant1;
    private Object participant2;
    private int score1;
    private int score2;
    private boolean termine;
    private LocalDate datePrevue;

    public Match() {
    }

    public Match(String id, String tournoiId, int tour, int position,
                 Object participant1, Object participant2,
                 LocalDate datePrevue) {
        this.id = id;
        this.tournoiId = tournoiId;
        this.tour = tour;
        this.position = position;
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.datePrevue = datePrevue;
    }


    public boolean estPrete() {
        return participant1 != null && participant2 != null && !termine;
    }


    public void enregistrerResultat(int score1, int score2) {
        if (!estPrete()) {
            throw new IllegalStateException(
                    "Le match n'est pas prêt à recevoir un résultat.");
        }

        this.score1 = score1;
        this.score2 = score2;
        this.termine = true;
    }

    public void reinitialiser() {
        this.score1 = 0;
        this.score2 = 0;
        this.termine = false;
    }


    public Object getVainqueur() {
        if (!termine || score1 == score2) {
            return null;
        }
        return score1 > score2 ? participant1 : participant2;
    }


    public Object getPerdant() {
        Object vainqueur = getVainqueur();
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


    public String getScoreAffichage() {
        return termine ? score1 + " - " + score2 : "-";
    }

    public String getNomParticipant1() {
        return nomParticipant(participant1);
    }

    public String getNomParticipant2() {
        return nomParticipant(participant2);
    }

    private static String nomParticipant(Object participant) {
        if (participant == null) {
            return "En attente";
        }
        if (participant instanceof Joueur) {
            return ((Joueur) participant).getNomAffichage();
        }
        if (participant instanceof Equipe) {
            return ((Equipe) participant).getNomAffichage();
        }
        return participant.toString();
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

    public Object getParticipant1() {
        return participant1;
    }

    public void setParticipant1(Object participant1) {
        this.participant1 = participant1;
    }

    public Object getParticipant2() {
        return participant2;
    }

    public void setParticipant2(Object participant2) {
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
    public String toString() {
        return getNomParticipant1() + " " + getScoreAffichage()
                + " " + getNomParticipant2();
    }
}
