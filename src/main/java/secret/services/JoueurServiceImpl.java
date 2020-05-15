package secret.services;

import lombok.NonNull;
import secret.model.Joueur;
import secret.model.Proclamation;

public class JoueurServiceImpl implements  JoueurService {

    @Override
    public Joueur defausser(@NonNull Joueur joueur, @NonNull Proclamation proclamation) {
        /*
         * Méthode qui procède à la défausse de la proclamation en argument dans la main du joueur
         *
         * @param joueur       doit posséder une main sinon ne se passe rien.
         * @param proclamation doit être contenu au moins une fois dans la main de joureur
         * @return l'instance de joueur dont la main a perdu un seul élément égal à proclamation
         */
        if (joueur.getMain()!=null){
            joueur.getMain().remove(proclamation);
        }
        return joueur;
    }
}
