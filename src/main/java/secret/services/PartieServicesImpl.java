package secret.services;

import lombok.NonNull;
import secret.model.*;
import secret.model.exceptions.NonImplementeException;
import secret.model.tour.Tour;

import java.util.*;

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
        attribuerLesRoles(retour);
        return retour;
    }

    @Override
    public Partie attribuerLesRoles(@NonNull Partie partie) {
        List<RoleSecret> roleSecrets = creerEtMelangerRoles(partie.getNbJoueurs());
        distribuerRolesAuxJoueurs(roleSecrets, partie.getJoueurs());
        return partie;
    }

    private void distribuerRolesAuxJoueurs(List<RoleSecret> roleSecrets, Set<Joueur> joueurs) {
        int i=0;
        for (Joueur joueur:joueurs){
            joueur.setRoleSecret(roleSecrets.get(i));
            i++;
        }
    }

    private List<RoleSecret> creerEtMelangerRoles(int nbJoueurs) {
        List<RoleSecret> roleSecrets = new ArrayList<>();
        roleSecrets.add(RoleSecret.VOLDEMORT);

        int nbPhenix=PartieServices.NB_PHENIX_PARMI_JOUEURS.get(nbJoueurs);
        roleSecrets.addAll(Collections.nCopies(nbPhenix,RoleSecret.ORDRE_DU_PHENIX));

        int nbMangeMort=nbJoueurs-1-nbPhenix;
        roleSecrets.addAll(Collections.nCopies(nbMangeMort,RoleSecret.MANGE_MORT));

        Collections.shuffle(roleSecrets);

        return roleSecrets;
    }

}
