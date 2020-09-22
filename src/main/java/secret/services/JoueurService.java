package secret.services;

import lombok.NonNull;
import secret.model.Alegeance;
import secret.model.Joueur;
import secret.model.Proclamation;

import java.util.List;

public interface JoueurService {


    /**
     * Méthode qui procède à la défausse de la proclamation en argument dans la main du joueur.
     * Les conditions demandées pour les paramètres doivent avoir été vérifiées au préalable
     * avant l'appel de la méthode : les implémentations ne sont pas sensées faire des vérifications.
     *
     * @param joueur doit posséder une main sinon ne se passe rien.
     * @param proclamation doit être contenu au moins une fois dans la main de joueur
     *
     * @return l'instance de joueur dont la main a perdu un seul élément égal à proclamation
     */
    Joueur defausser(@NonNull Joueur joueur, @NonNull  Proclamation proclamation);

    /**
     * Rechercer l'all&égenace d'un joueur dans une liste à partir de son id.
     * @param nomJoueur le nomJhoueur (id) du joueur dont on cherhce l'allégeance
     * @param joueurs la liste des joueurs dans laquelle trouver le joueur
     * @return le field allegeance du joueur de la liste joueurs dont l'id correpond au paramètre nomJoueur ou bine null
     * si rien trouvé
     */
    Alegeance findAlegeance(@NonNull String nomJoueur, @NonNull List<Joueur> joueurs);
}
