package secret.api;

import lombok.NonNull;
import secret.model.Joueur;
import secret.model.Partie;
import secret.model.exceptions.IdJoueurIncorrectException;
import secret.model.exceptions.NbJoueursIncorrectsException;
import secret.services.PartieServices;
import secret.services.TourServices;

import java.util.Date;

public class PartieApiImpl implements PartieApi{

    private PartieServices partieServices;
    private TourServices tourServices;

    @Override
    public Partie creerPartie(int nbJoueurs, String nomPartie) throws NbJoueursIncorrectsException {

        if(nomPartie==null){
            nomPartie=(new Date())+"_"+nbJoueurs+" joueurs";
        }

        Partie retour=new Partie(nbJoueurs, nomPartie);
        return partieServices.save(retour);
    }

    /**
     * Méthode appelée pour la création d'un nouveau joueur au sein d'une partie.
     * Lorsque le dernier joueur attendu a été créé, la partie commence automatiquement.
     *
     * @param partie   la partie pour laquelle le joueur doit être créé
     * @param idJoueur id du joueur créé : doit être unique et respecter des ctes sur le nom (à définir dans la méthode appliquant la règle de gestion)
     * @return le joueur créé
     * @throws IdJoueurIncorrectException si id incorrect (respect du format...) ou si id existe déjà
     */
    @Override
    public Joueur creerJoueur(@NonNull  Partie partie, @NonNull String idJoueur) throws IdJoueurIncorrectException, NbJoueursIncorrectsException {
        Joueur nouveauJoueur=new Joueur(idJoueur);
        partie.ajouterJoueur(nouveauJoueur);
        if (partie.isTousLesJoueursPresent()){
            partieServices.debuterPartieEtDistribuerRoles(partie.getId());
            tourServices.commencerPremierTour(partie);
        }
        return nouveauJoueur;
    }
}
