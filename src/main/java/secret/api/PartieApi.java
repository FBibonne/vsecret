package secret.api;

import lombok.NonNull;
import secret.model.Joueur;
import secret.model.Partie;
import secret.model.exceptions.IdJoueurIncorrectException;
import secret.model.exceptions.NbJoueursIncorrectsException;

public interface PartieApi {
    /**
     * Méthode appelée pour la création d'une partie
     * @param nbJoueurs : doit être un entier entre 5 et 10
     * @param nomPartie : pas de contrainte. Si null, un nom automatique est généré
     * @return la partie créée
     * @throws NbJoueursIncorrectsException si pas entre 5 et 10
     */
    public Partie creerPartie(int nbJoueurs, String nomPartie) throws NbJoueursIncorrectsException;

    /**
     * Méthode appelée pour la création d'un nouveau joueur au sein d'une partie.
     * Lorsque le dernier joueur attendu a été créé, la partie commence automatiquement
     * (distribution des rôles aux joueurs, chgt des états, commencement du 1er tour)
     * @param partie la partie pour laquelle le joueur doit être créé
     * @param idJoueur id du joueur créé : doit être unique et respecter des ctes sur le nom (à définir dans la méthode appliquant la règle de gestion)
     * @return le joueur créé
     * @throws IdJoueurIncorrectException  si id incorrect (respect du format...) ou si id existe déjà
     */
    public Joueur creerJoueur(@NonNull  Partie partie, @NonNull String idJoueur) throws IdJoueurIncorrectException, NbJoueursIncorrectsException;

}
