package secret.services;

import lombok.NonNull;
import lombok.Setter;
import secret.model.Proclamation;
import secret.model.tour.Tour;
import secret.model.exceptions.MinistreNePossedePasDefausseException;

@Setter
public class TourServicesImpl implements TourServices {




    @Override
    public void verifierMinistrePossedeProclamationDefausseeSinonException(@NonNull Tour tour, @NonNull Proclamation proclamation) throws MinistreNePossedePasDefausseException {

        if (tour.hasMinistreElu()
                && tour.getMainDuMinstreElu() != null
                && !tour.getMainDuMinstreElu().contains(proclamation)) {
            throw new MinistreNePossedePasDefausseException(proclamation);
        }
    }


    @Override
    //TODO Tester
    public Tour ministreTransmetDeuxProclamationAuDirecteur(Tour tour) {

        if (tour.getMinistre()!=null && tour.getDirecteur()!=null){
            tour.getDirecteur().setMain(tour.getMinistre().extraireDeuxPremieresProclamations());
        }
        return tour;
    }

}
