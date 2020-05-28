package secret.services;

import lombok.NonNull;
import secret.model.Partie;
import secret.model.Pouvoir;
import secret.model.exceptions.NbJoueursIncorrectsException;
import secret.model.exceptions.NonImplementeException;
import secret.model.tour.Tour;

import java.util.HashMap;
import java.util.Map;

public class PartieServicesImpl implements PartieServices {

    private Map<Long, Partie> parties=new HashMap<>();

    @Override
    public Partie jouerAvadaKedavra(@NonNull Pouvoir pouvoir, @NonNull Tour tour) {
        throw new NonImplementeException();
    }

    @Override
    public Partie save(@NonNull  Partie partie) {
        partie.setId(parties.keySet().stream().mapToLong(Long::longValue).max().orElse(0)+1);
        parties.put(partie.getId(), partie);
        return partie;
    }

    @Override
    public Partie debuterPartieEtDistribuerRoles(@NonNull Long partieId) {
        Partie retour=parties.get(partieId);
        retour.debuterPartie();
        distribuer les rôles
        return retour;
    }

}
