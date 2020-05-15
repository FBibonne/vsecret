package secret.services.tour;

import lombok.NonNull;
import secret.model.tour.SessionLegislative;

public interface SessionLegislativeServices {

    /**
     * Cette méthode organise une distribution d'un triplet de Proclamations
     * au ministre élu pour le sessionLegislative.
     * <br/>
     * Si le sessionLegislative a un ministre élu, un triplet de Proclamations est fourni par le service
     * ProclamationService.tirage et donné à la main du ministre élu.
     * <br/>
     * Passe l'état du sessionLegislative à ???
     * <br/>
     * <h3>CETTE METHODE NE DOIT ETRE APPELLEE QU'UNE SEULE FOIS DANS LE TOUR</h3>
     * La main du joueur désigné comme ministre de la magie est aussi mofifiée par méthode
     * puisqu'elle reçoit les Proclamations tirées (affectation de la liste tirée au champ main du ministre)
     * <br/>
     * Ne fait rien si le sessionLegislative n'a pas un ministre élu
     * @param sessionLegislative pour lequel effectuer le tirage
     * @return le sessionLegislative passé en paramètre et modifié par la méthode.
     */
    public SessionLegislative ministrePiocheProclamations(@NonNull SessionLegislative sessionLegislative);
}
