package secret.services;

import lombok.NonNull;
import secret.model.Partie;
import secret.model.Pouvoir;
import secret.model.tour.Tour;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface PartieServices {

    /**
     * Constante qui représente le nombre de membres de
     * l'ordre du PHENIX à respecter pour attribuer les
     * rôles aux joueurs.
     * <br/>
     * Le nombre est précisé pour chaque nombre de
     * participants possible au jeu
     */
    Map<Integer,Integer> NB_PHENIX_PARMI_JOUEURS=genererNbPhenixParmiJoueurs();

    static Map<Integer, Integer> genererNbPhenixParmiJoueurs() {
        Map<Integer,Integer> retour= new HashMap<>();
        retour.put(5, 3);
        retour.put(6, 4);
        retour.put(7, 4);
        retour.put(8, 5);
        retour.put(9, 5);
        retour.put(10, 6);

        if (retour.get(Partie.NB_JOUEURS_MIN)==null || retour.get(Partie.NB_JOUEURS_MAX)==null){
            throw new Error("PartieServices.NB_PHENIX_PARMI_JOUEURS ne contient pas de valeur pour NB_JOUEURS_MIN ou NB_JOUEURS_MAX");
        }
        retour=Collections.unmodifiableMap(retour);
        
        return retour;
    }

    Partie jouerAvadaKedavra(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

    Partie save(@NonNull  Partie partie);

    Partie debuterPartieEtDistribuerRoles(@NonNull Long partieId);

    /**
     * Distribuer les rôles aux joueurs de la partie suivant le nombre de joueurs.
     * Ne fonctionne que si la partie est débutée et si le joueurs.size==nbjoueurs
     * @param partie : doit vérifier tous les joueurs présents
     * @return l'instance actuelle modifiée
     */
    Partie attribuerLesRoles(Partie partie);
}
