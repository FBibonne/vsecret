package secret.services.tour;

import lombok.NonNull;
import secret.model.PileProclamations;
import secret.model.Proclamation;
import secret.model.exceptions.MinistreNePossedePasDefausseException;
import secret.model.tour.Election;
import secret.model.tour.SessionLegislative;

public interface SessionLegislativeServices {

    /**
     * Méthode qui vérifie que le ministre du tour passé en paramètre a bien en main une proclamation égale à
     * le proclamation passée en paramètre.
     * Si ce n'est pas le cas, la méthode lève une exsception sinon ne fait rien
     *
     * @param sessionLegislative : on regarde la main de ministre.tour. Si un des champs est null, ne fait rien
     * @param proclamation
     */
    SessionLegislative verifierMinistrePossedeProclamationDefausseeSinonException(@NonNull SessionLegislative sessionLegislative, @NonNull Proclamation proclamation) throws MinistreNePossedePasDefausseException;

    /**
     * Méthode qui transmet du ministre au directeur les deux proclamations qui restent dans la main du ministre :
     * les deux premières proclamations de la main du ministre lui sont retirées et affectées à la main du directeur.
     * <br/>
     * Si le ministre ou le directeur est null, ne fait rien.
     * <br/>
     * Si ministre.main est null ou ministre.main.size<2, affecte une liste vide dans la main du directeur
     * @param sessionLegislative : le tour contenant le ministre et le directeur élu concernés par le transfert
     * @return le tour ainsi modifié.
     */
    SessionLegislative ministreTransmetDeuxProclamationAuDirecteur(@NonNull SessionLegislative sessionLegislative);


    /**
     * Cette méthode organise une distribution d'un triplet de Proclamations
     * au ministre élu pour le sessionLegislative.
     * <br/>
     * Si le sessionLegislative a un ministre élu, un triplet de Proclamations est fourni par le service
     * ProclamationService.tirage et donné à la main du ministre élu.
     * <br/>
     * Passe l'état du sessionLegislative à piocheDejaEffectuee=true
     * <br/>
     * <h3>CETTE METHODE NE DOIT ETRE APPELLEE QU'UNE SEULE FOIS DANS LE TOUR</h3>
     * La main du joueur désigné comme ministre de la magie est aussi mofifiée par méthode
     * puisqu'elle reçoit les Proclamations tirées (affectation de la liste tirée au champ main du ministre)
     * <br/>
     * Ne fait rien si le sessionLegislative n'a pas un ministre élu
     * @param sessionLegislative pour lequel effectuer le tirage
     * @param pileProclamations la pile de proclamation de la partie ou piocher
     * @return le sessionLegislative passé en paramètre et modifié par la méthode.
     */
    SessionLegislative ministrePiocheProclamations(@NonNull SessionLegislative sessionLegislative,  @NonNull PileProclamations pileProclamations);

    SessionLegislative creer(Election electionCourante);
}
