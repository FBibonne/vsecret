package secret.services.tour;

import lombok.NonNull;
import lombok.Setter;
import secret.model.Partie;
import secret.model.PileProclamations;
import secret.model.tour.SessionLegislative;
import secret.model.tour.Tour;
import secret.services.ProclamationServices;

@Setter
public class TourServicesImpl implements TourServices {

    private SessionLegislativeServices sessionLegislativeServices;
    private ProclamationServices proclamationServices;

    @Override
    public Tour commencerElection(@NonNull Tour tour) {
       // instancier l'objet et changer l'état
    }

    @Override
    public Tour commencerSessionLegislative(@NonNull Tour tour, @NonNull PileProclamations pileProclamations) {
        SessionLegislative sessionLegislative=sessionLegislativeServices.creer(tour.getElectionCourante());
        sessionLegislativeServices.ministrePiocheProclamations(sessionLegislative, pileProclamations);
        tour.setSessionLegislative(sessionLegislative);
        return tour;
    }

    @Override
    public Tour commencerNouveauTour(@NonNull Tour tourTermine) {

        // créer le tour avec le bon état
        // commencerElection(Tour)
    }

    @Override
    public Tour commencerPremierTour(@NonNull Partie partie) {
        // choisir un candidat ministre aléatoirement
        // commencerNouveauTour

    }

}
