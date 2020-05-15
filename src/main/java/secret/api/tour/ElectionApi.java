package secret.api.tour;

import lombok.NonNull;
import secret.model.tour.Election;
import secret.model.tour.Tour;

public interface ElectionApi {

    public Election designerCandidatDirecteur(@NonNull Designation designation, @NonNull Election election);

    /**
     * Enregistre le vote pour l'élection courante (vérifications : election bien en cours, joueur n'a pas déjà voté,
     * ...). Lorsque le dernier joueur a voté, clos l'élection :
     * <ul>
     *     <li>votes deviennent publics</li>
     *     <li>demarrer un suivi de l'élection</li>
     * </ul>
     * @param vote
     * @param election
     * @return
     */
    public Election voter(@NonNull Vote vote, @NonNull Election election);



}
