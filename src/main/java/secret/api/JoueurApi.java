package secret.api;

import lombok.NonNull;
import secret.model.Joueur;
import secret.model.Partie;
import secret.model.RoleSecret;
import secret.model.exceptions.OperationInterditeParEtatException;
import secret.model.exceptions.OperationInterditePourRoleJoueur;

import java.util.Map;

public interface JoueurApi {

    /**
     * Cette méthode renvoie un roleSecret pour chaque identifiant de Joueur existant dans la partie.
     *
     * La méthode vérifie la règle suivante avant de retourner l'information :
     * de 7 à 10j, le demandeur doit être un mangemort mais pas Voldemort de 5 à 6 j, le demandeur
     * doit être un mangemort y compris Voldemort (le contrôle se fait en consultant le rôle deu demandeur)
     *
     * @param demandeur : correspond au joueur qui fait la demande de voir les joueurs.
     * @param partie : la partie pour laquelle les roles doivent être retournés
     * @return une map qui associe un role à chaque id de joueur.
     * @throws OperationInterditeParEtatException : Si l'état de la partie n'est pas approprié ( != EtatPartie.EN_COURS (tous les joueurs doivent être inscrits et les rôles distribués))
     * @throws OperationInterditePourRoleJoueur : si le role du joueur ne respecte la règle de gestion énnoncée plus haut
     */
    Map<String, RoleSecret> listerRoles(@NonNull Joueur demandeur, @NonNull Partie partie) throws OperationInterditeParEtatException, OperationInterditePourRoleJoueur;
}
