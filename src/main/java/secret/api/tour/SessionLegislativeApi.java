package secret.api.tour;

import lombok.NonNull;
import secret.model.Proclamation;
import secret.model.Promulgation;
import secret.model.tour.Defausse;
import secret.model.tour.SessionLegislative;
import secret.model.exceptions.DefausseurPasMinistreException;
import secret.model.exceptions.MinistreNePossedePasDefausseException;
import secret.model.exceptions.OperationInterditePourEtatTourException;
import secret.model.tour.Tour;

import java.util.List;

public interface SessionLegislativeApi {

    /**
     * Gère la défausse du minitre.
     * Le ministre défausse une carte de sa main (defausse.procalmation) et le système passe dans la mains du directeur
     * les deux proclamations restantes lors de la session legislative du sessionLegislative.
     * A l'issue de cette méthode, la main du directeur reçoit les deux cartes qui faisaient partie de la main du ministre
     * et qui ne sont pas défaussées.
     * <br/>
     * La méthode vérifie que :
     * <ul>
     *     <li>Le sessionLegislative est en session legislative et que le ministre de la magie a bien une main</li>
     *     <li>Qu'une défausse n'a pas déjà eu lieu pour ce sessionLegislative</li>
     *     <li>Que le joueur désigné comme fournisseur dans defausse est bien le ministre</li>
     *     <li>Que la carte à défausser  se trouve bien dans la main du ministre</li>
     * </ul>
     * Si une des conditions n'est pas vérifiée, la méthode lève une exception
     * <br/>
     * Changement d'états ?la défausse ne pourra pas être rejouée. Le directeur peut ensuite consulter sa main
     * @param defausse : la défausse à gérer dans le sessionLegislative
     * @param sessionLegislative : le sessionLegislative courant concerné par la défausse et le passage de proclamations du ministre au directeur
     * @return le sessionLegislative courant modifié par l'action de la méthode
     * @throws OperationInterditePourEtatTourException, DefausseurPasMinistreException, MinistreNePossedePasDefausseException : si conditions par respectées
     */
    public SessionLegislative defausserEtpasserProclamationsAuDirecteur(@NonNull Defausse defausse, @NonNull SessionLegislative sessionLegislative) throws OperationInterditePourEtatTourException, DefausseurPasMinistreException, MinistreNePossedePasDefausseException;

    /**
     * Api par laquelle le directeur promulgue sa proclamation parmi les deux cartes qu'il a en main.
     *
     * Vérifications :
     * <lu>
     *     <li> Etat tour : Tour en session legislative la défausse a déjà eu lieu (mais la procalmation pas encore)</li>
     *     <li> Identité : vérifier que le promugalteur est bien le directeur</li>
     *     <li> Carte : vérifier que la carte promulguée est bien dans la main du directeur</li>
     *
     * </lu>
     * Si Ok, retient la promulgation dans la session legisltative
     *
     * @param promulgation
     * @param sessionLegislative
     * @return
     */
    SessionLegislative promulguerProclamation(@NonNull Promulgation promulgation, @NonNull SessionLegislative sessionLegislative);

}
