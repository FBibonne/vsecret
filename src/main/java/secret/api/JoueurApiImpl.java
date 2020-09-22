package secret.api;

import lombok.NonNull;
import secret.api.JoueurApi;
import secret.model.EtatPartie;
import secret.model.Joueur;
import secret.model.Partie;
import secret.model.RoleSecret;
import secret.model.exceptions.OperationInterditeParEtatException;
import secret.model.exceptions.OperationInterditePourRoleJoueur;
import secret.services.PartieServices;

import javax.management.relation.Role;
import java.util.HashMap;
import java.util.Map;

public class JoueurApiImpl implements JoueurApi {
    private PartieServices partieServices;

    @Override
    public Map<String, RoleSecret> listerRoles(@NonNull Joueur demandeur, @NonNull Partie partie) throws OperationInterditeParEtatException, OperationInterditePourRoleJoueur {

        if (partie.getEtat()!= EtatPartie.EN_COURS){
            throw new OperationInterditeParEtatException(partie.getEtat(), "lister les rôles");
        }
        if (5<=partie.getNbJoueurs()&&partie.getNbJoueurs()<=6&&demandeur.getRoleSecret()!=RoleSecret.MANGE_MORT&& demandeur.getRoleSecret()!=RoleSecret.VOLDEMORT){
            throw new OperationInterditePourRoleJoueur(demandeur, " lorsque que 5 ou 6 joueurs seuls MANGE_MORT et VOLDEMORT peuvent voir les rôles");
        }
        if (7<=partie.getNbJoueurs()&&partie.getNbJoueurs()<=10&&demandeur.getRoleSecret()!=RoleSecret.MANGE_MORT){
            throw new OperationInterditePourRoleJoueur(demandeur, " lorsque que 7 à 10 joueurs seuls MANGE_MORT peuvent voir les rôles ( et pas VOLDEMORT)");
        }

        return partieServices.listerRoles(partie);
    }
}
