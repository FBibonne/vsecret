package secret.api.tour;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import secret.model.tour.Defausse;
import secret.model.tour.Tour;
import secret.model.exceptions.DefausseurPasMinistreException;
import secret.model.exceptions.MinistreNePossedePasDefausseException;
import secret.model.exceptions.OperationInterditePourEtatTourException;
import secret.services.JoueurService;
import secret.services.TourServices;

@Getter
@Setter
public class SessionLegislativeApiImpl implements SessionLegislativeApi {

    private TourServices tourServices;
    private JoueurService joueurService;


    @Override
    //TODO TEster
    public Tour defausserEtpasserProclamationsAuDirecteur(@NonNull Defausse defausse, @NonNull Tour sessionLegislative) throws OperationInterditePourEtatTourException, DefausseurPasMinistreException, MinistreNePossedePasDefausseException {

        if (! sessionLegislative.isSessionLegislative()) {
            throw new OperationInterditePourEtatTourException(sessionLegislative.getEtat());
        }
        if (sessionLegislative.isDefausseDejaEffectuee()) {
            throw new OperationInterditePourEtatTourException(sessionLegislative.getEtat(), "defausse déjà effectuée pour ce tour");
        }
        if (! defausse.getDefausseur().equals(sessionLegislative.getMinistre())){
            throw new DefausseurPasMinistreException(defausse.getDefausseur(), sessionLegislative.getMinistre());
        }
        tourServices.verifierMinistrePossedeProclamationDefausseeSinonException(sessionLegislative, defausse.getProclamation());

        joueurService.defausser(sessionLegislative.getMinistre(), defausse.getProclamation());
        sessionLegislative =tourServices.ministreTransmetDeuxProclamationAuDirecteur(sessionLegislative);

        sessionLegislative.setDefausseDejaEffectuee(true);

        return sessionLegislative;
    }
}
