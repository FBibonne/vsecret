package secret.services;

import lombok.NonNull;
import secret.model.Partie;
import secret.model.Pouvoir;
import secret.model.tour.Tour;

public interface PartieServices {

    public Partie jouerAvadaKedavra(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

}
