package secret.api.tour;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import secret.model.Promulgation;
import secret.model.exceptions.DefausseurPasMinistreException;
import secret.model.exceptions.MinistreNePossedePasDefausseException;
import secret.model.exceptions.OperationInterditePourEtatTourException;
import secret.model.tour.Defausse;
import secret.model.tour.SessionLegislative;
import secret.services.JoueurService;
import secret.services.tour.SessionLegislativeServices;

@Getter
@Setter
public class SessionLegislativeApiImpl implements SessionLegislativeApi {

    private SessionLegislativeServices sessionLegislativeServices;
    private JoueurService joueurService;


    @Override
    //TODO TEster
    public SessionLegislative defausserEtpasserProclamationsAuDirecteur(@NonNull Defausse defausse, @NonNull SessionLegislative sessionLegislative) throws OperationInterditePourEtatTourException, DefausseurPasMinistreException, MinistreNePossedePasDefausseException {

        if (sessionLegislative.isDefausseDejaEffectuee()) {
            throw new OperationInterditePourEtatTourException(sessionLegislative.getEtat(), "defausse déjà effectuée pour ce tour");
        }
        if (! defausse.getDefausseur().equals(sessionLegislative.getMinistre())){
            throw new DefausseurPasMinistreException(defausse.getDefausseur(), sessionLegislative.getMinistre());
        }
        sessionLegislativeServices.verifierMinistrePossedeProclamationDefausseeSinonException(sessionLegislative, defausse.getProclamation());

        joueurService.defausser(sessionLegislative.getMinistre(), defausse.getProclamation());
        sessionLegislative =sessionLegislativeServices.ministreTransmetDeuxProclamationAuDirecteur(sessionLegislative);

        sessionLegislative.defausse();

        return sessionLegislative;
    }

    @Override
    public SessionLegislative promulguerProclamation(@NonNull Promulgation promulgation, @NonNull SessionLegislative sessionLegislative) {
        return null;
    }
}
