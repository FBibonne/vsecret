package secret.services.tour;

import lombok.NonNull;
import secret.model.Partie;
import secret.model.PileProclamations;
import secret.model.tour.Tour;
import secret.services.ProclamationServices;

public interface TourServices {

    int ID_PREMIER_TOUR = 1;

    public void setProclamationServices(ProclamationServices proclamationServices);

    public Tour commencerSessionLegislative(@NonNull Tour tour, @NonNull PileProclamations pileProclamations);

    public Tour commencerNouveauTour(@NonNull Tour tourPrecedent);

    public Tour commencerPremierTour(@NonNull Partie partie);
}
