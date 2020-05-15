package secret.model.tour;

import lombok.NonNull;
import secret.model.Joueur;
import secret.model.Proclamation;

import java.util.List;

public class SessionLegislative {

    private Joueur ministre;

    public boolean hasMinistre() {
        return ministre!=null;
    }

    /**
     * Si un ministre est élu, donne les proclmations tirées passées en paramètre
     * au ministre.
     * <br/>
     * concrètement, le tirage passé en paramètre est affecté à ministreElu.main
     * @param tirage : les proclamations tirées
     * @throws IllegalStateException si pas de ministre elu
     */
    public void donnerProclamationPiocheesAuMinistre(@NonNull List<Proclamation> tirage) {

        if(!hasMinistre()){
            throw new IllegalStateException("Impossible d'appeler donnerProclamationPiocheesAuMinistreElu dans le tour "+this+" : hasMinistreElu()=false");
        }
        ministre.setMain(tirage);
    }

}
