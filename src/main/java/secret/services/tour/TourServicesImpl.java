package secret.services.tour;

import lombok.NonNull;
import lombok.Setter;
import secret.model.Partie;
import secret.model.PileProclamations;
import secret.model.tour.FournisseurProchainCandidatMinistre;
import secret.model.tour.SessionLegislative;
import secret.model.tour.Tour;
import secret.services.ProclamationServices;

@Setter
public class TourServicesImpl implements TourServices {

    private SessionLegislativeServices sessionLegislativeServices;
    private ProclamationServices proclamationServices;

    @Override
    public Tour commencerSessionLegislative(@NonNull Tour tour, @NonNull PileProclamations pileProclamations) {
        SessionLegislative sessionLegislative=sessionLegislativeServices.creer(tour.getElectionCourante());
        sessionLegislativeServices.ministrePiocheProclamations(sessionLegislative, pileProclamations);
        tour.setSessionLegislative(sessionLegislative);
        return tour;
    }

    @Override
    public Tour commencerNouveauTour(@NonNull Tour tourPrecedent) {
        return new Tour(tourPrecedent.getFournisseurProchainCandidatMinistre(), tourPrecedent.getId()+1);
    }

    @Override
    public Tour commencerPremierTour(@NonNull Partie partie) {
        FournisseurProchainCandidatMinistre fournisseurProchainCandidatMinistre=new FournisseurProchainCandidatMinistre(partie.getJoueurs());
        return new Tour(fournisseurProchainCandidatMinistre, TourServices.ID_PREMIER_TOUR);
    }

}
