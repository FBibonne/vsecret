package secret.api.tour;

import lombok.NonNull;
import secret.model.Designation;
import secret.model.Partie;
import secret.model.Vote;
import secret.model.tour.Election;
import secret.model.tour.Tour;

public interface ElectionApi {

    /**
     * Retourne l'élection en cours du tour en cours de la partie en paramètre
     * @param partie
     * @return l'élection cherchée mais null si elle n'existe pas
     */
    public Election findElectionCourante(@NonNull Partie partie);

    /**
     * Méthode appelée lorque le ministre candidat choisit un directeur pour l'élection en objet. L'état de
     * l'élection doit permettre l'opération et la désignation doit être valide (designation.ministre est bien ministre candidat
     * et designation.nomDirecteur identifie bien un joueur qui a le droit d'être directeur). Sinon des exceptions sont levées.
     * @param designation
     * @param election
     * @return
     */
    public Election designerCandidatDirecteur(@NonNull Designation designation, @NonNull Election election);

    /**
     * Enregistre le vote pour l'élection courante (vérifications : election bien en cours, joueur n'a pas déjà voté,
     * ...). Lorsque le dernier joueur a voté, clos l'élection :
     * <ul>
     *     <li>votes deviennent publics</li>
     *     <li>demarrer un suivi de l'élection au niveau de la partie</li>
     *     <li>Election change d'état</li>
     * </ul>
     * @param vote
     * @param election
     * @return le tour associé à l'élection pour connare l'état de tour et éventuellement le résultat de l'élection ou le résultat
     * de la partie si Voldemort élu après le 3ème tour
     */
    public Tour voter(@NonNull Vote vote, @NonNull Election election);



}
