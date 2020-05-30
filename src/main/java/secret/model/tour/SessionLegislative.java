package secret.model.tour;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import secret.model.Joueur;
import secret.model.PileProclamations;
import secret.model.Proclamation;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class SessionLegislative {

    /**
     * Le ministre elu.
     * <br/>
     * NB : vérifier la cohérence avec etat : etat==SESSION_LEGISLATIVE => ministre !=null
     * => pas de setter
     *
     */
    @NonNull
    private Joueur ministreElu;

    /**
     * Le directeur elu.
     * <br/>
     * NB : vérifier la cohérence avec etat : etat==SESSION_LEGISLATIVE => directeur !=null
     * => pas de setter
     *
     */
    @NonNull
    private Joueur directeurElu;

    @Getter
    private boolean defausseDejaEffectuee=false;


    @Getter
    private boolean piocheDejaEffectuee=false;


    /**
     * Si un ministre est élu, donne les proclmations tirées passées en paramètre
     * au ministre.
     * <br/>
     * concrètement, le tirage passé en paramètre est affecté à ministreElu.main
     * @param tirage : les proclamations tirées
     * @throws IllegalStateException si pas de ministre elu
     */
    public void donnerProclamationPiocheesAuMinistre(@NonNull List<Proclamation> tirage) {
        ministreElu.setMain(tirage);
        piocheDejaEffectuee=true;
    }

    public List<Proclamation> getMainDuMinstreElu() {
        return ministreElu.getMain();
    }

    public EtatTour getEtat() {
        return EtatTour.SESSION_LEGISLATIVE;
    }

    public void defausse() {
        defausseDejaEffectuee=true;
    }
}
