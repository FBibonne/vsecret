package secret.services;

import lombok.NonNull;
import secret.model.Alegeance;
import secret.model.Joueur;
import secret.model.Proclamation;

public interface JoueurService {


    /**
     * Méthode qui procède à la défausse de la proclamation en argument dans la main du joueur
     *
     * @param joueur doit posséder une main sinon ne se passe rien.
     * @param proclamation doit être contenu au moins une fois dans la main de joureur
     *
     * @return l'instance de joueur dont la main a perdu un seul élément égal à proclamation
     */
    public Joueur defausser(@NonNull Joueur joueur, @NonNull  Proclamation proclamation);

    public Alegeance findAlegeance(String nomJoueur);
}
