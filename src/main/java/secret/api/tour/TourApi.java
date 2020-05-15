package secret.api.tour;

import lombok.NonNull;
import secret.model.tour.Election;
import secret.model.tour.Tour;

public interface TourApi {


    /**
     * Met fin à la session legislative courante qui doit avoir une promlgation
     *  <ul>
     *     <li> recopie la promulgation dans le tour </li>
     *     <li>Mise à jour de la progression de la partie</li>
     *     <li>si la progression de la partie autorise l'exécution d'un pouvoir spécial : passer à l'état ACTION_EXECUTIVE
     *     pour jouer ce pouvoir</li>
     *     <lu>si pas de pouvoir spécial à jouer : fin du tour</lu>
     * </ul>
     *
     * <h3> Méthode qui modifie la partie</h3>
     * public Tour terminerSessionLegisltative(@NonNull Tour, )
     * <p>
     * /**
     * entérine le résultat.
     * si élection  OK, déclenche la session legislative (sessionLegislativeApi.tirerCartesPourMinistreMagie)
     * si election KO incrémente le rejet,
     * si moins de 3 rejets, commence une nouvelle élection
     * si 3 rejets, joue le chaos (
     *
     * @param tour
     * @return
     */
    public Tour suivreElections(@NonNull Tour tour);

    public Tour jouerChaos(@NonNull Tour tour);
}
