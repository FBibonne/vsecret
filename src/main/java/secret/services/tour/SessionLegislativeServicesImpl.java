package secret.services.tour;

import lombok.NonNull;
import secret.model.tour.SessionLegislative;
import secret.services.PileProclamationsServices;
import secret.services.ProclamationServices;

public class SessionLegislativeServicesImpl implements  SessionLegislativeServices {

    private ProclamationServices proclamationServices;

    private PileProclamationsServices pileProclamationsServices;

    @Override
    public SessionLegislative ministrePiocheProclamations(@NonNull SessionLegislative sessionLegislative) {

        if (sessionLegislative.hasMinistre()) {
            sessionLegislative.donnerProclamationPiocheesAuMinistre(proclamationServices.tirage(pileProclamationsServices.findPileProclamations()));
        }

        return sessionLegislative;
    }
}
