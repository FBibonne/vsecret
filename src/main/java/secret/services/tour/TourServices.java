package secret.services.tour;

import lombok.NonNull;
import secret.model.Partie;
import secret.model.PileProclamations;
import secret.model.tour.Tour;
import secret.services.ProclamationServices;

public interface TourServices {

    public void setProclamationServices(ProclamationServices proclamationServices);

    /**
     * Initie une nouvelle élection si aucune n'est déjà en cours....
     * Désigne automatiquement le candidat ministre pour l'élection à venir
     *
     * @param tour
     * @return le tour avec l'élection dedans
     */
    public Tour commencerElection(@NonNull Tour tour);

    public Tour commencerSessionLegislative(@NonNull Tour tour, @NonNull PileProclamations pileProclamations);

    public Tour commencerNouveauTour(@NonNull Tour tourTermine);

    public Tour commencerPremierTour(@NonNull Partie partie);
}
