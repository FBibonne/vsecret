package secret.api.tour;

import lombok.NonNull;
import secret.model.Alegeance;
import secret.model.Partie;
import secret.model.tour.Tour;

public interface ActionExecutiveApi {

    public Alegeance jouerEndoloris(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

    /* NB : retourne la partie avec le futur ministre désigné par le pouvoir impero*/
    public Partie jouerImpero(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

    /* Retourne la partie avec état éventuel (gagné par ordre du phoenix si voldemort tué)
    et la liste des joueurs pour voir qui est tué/vivant
     */
    public Partie jouerAvadaKedavra(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

    public Tour jouerDivination(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

    public Tour directeurJoueExpelliarmus(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

    public Tour  ministreJoueExpelliarmus(@NonNull Pouvoir pouvoir, @NonNull Tour tour);
}
