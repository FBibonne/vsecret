package secret.services.tour;

import lombok.NonNull;
import secret.model.PileProclamations;
import secret.model.Proclamation;
import secret.model.exceptions.MinistreNePossedePasDefausseException;
import secret.model.tour.Election;
import secret.model.tour.SessionLegislative;
import secret.services.ProclamationServices;

public class SessionLegislativeServicesImpl implements  SessionLegislativeServices {

    private ProclamationServices proclamationServices;

    @Override
    public SessionLegislative ministrePiocheProclamations(@NonNull SessionLegislative sessionLegislative, @NonNull PileProclamations pileProclamations) {
        sessionLegislative.donnerProclamationPiocheesAuMinistre(proclamationServices.tirage(pileProclamations));
        return sessionLegislative;
    }

    @Override
    public SessionLegislative creer(Election electionCourante) {
        return new SessionLegislative(electionCourante.getMinistreElu(), electionCourante.getDirecteurElu());
    }


    @Override
    public SessionLegislative verifierMinistrePossedeProclamationDefausseeSinonException(@NonNull SessionLegislative sessionLegislative, @NonNull Proclamation proclamation) throws MinistreNePossedePasDefausseException {

        if (sessionLegislative.getMainDuMinstreElu() != null
                && !sessionLegislative.getMainDuMinstreElu().contains(proclamation)) {
            throw new MinistreNePossedePasDefausseException(proclamation);
        }
        return sessionLegislative;
    }


    @Override
    //TODO Tester
    public SessionLegislative ministreTransmetDeuxProclamationAuDirecteur(@NonNull SessionLegislative sessionLegislative) {
        sessionLegislative.getDirecteurElu().setMain(sessionLegislative.getMinistreElu().extraireDeuxPremieresProclamations());
        return sessionLegislative;
    }
}
