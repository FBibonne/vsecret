package secret.services;

import lombok.NonNull;
import secret.model.Partie;
import secret.model.Pouvoir;
import secret.model.exceptions.NbJoueursIncorrectsException;
import secret.model.tour.Tour;

public interface PartieServices {

    Partie jouerAvadaKedavra(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

    Partie save(@NonNull  Partie partie);

    Partie debuterPartie(@NonNull Long partieId);
}
