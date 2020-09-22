package secret.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import secret.model.exceptions.IdJoueurIncorrectException;
import secret.model.exceptions.NbJoueursIncorrectsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partie {

    public static final int NB_JOUEURS_MIN = 5;
    public static final int NB_JOUEURS_MAX = 10;

    @Getter
    private int nbJoueurs;
    private String nom;
    @Getter
    @Setter
    private Long id;
    @Getter
    private List<Joueur> joueurs=new ArrayList<>();
    private Integer rangProchainMinistre;
    @Getter
    private EtatPartie etat;

    public static void verifierNombreJoueursValidePourPartieSinonException(int nbJoueurs) throws NbJoueursIncorrectsException {
        if(nbJoueurs < NB_JOUEURS_MIN || nbJoueurs > NB_JOUEURS_MAX) {
            throw new NbJoueursIncorrectsException("Le nombre de joueurs demandé (" + nbJoueurs + ") n'est pas dans l'intervalle [" + NB_JOUEURS_MIN + " ; " + NB_JOUEURS_MAX + "]");
        }
   }

   public Partie(int nbJoueurs, @NonNull  String nom) throws  NbJoueursIncorrectsException{
        verifierNombreJoueursValidePourPartieSinonException(nbJoueurs);
        this.nom=nom;
        this.nbJoueurs=nbJoueurs;
        this.etat=EtatPartie.INITIALISATION;
   }

    public synchronized Partie ajouterJoueur(@NonNull  Joueur nouveauJoueur) throws NbJoueursIncorrectsException, IdJoueurIncorrectException {
        if (joueurs.size()>=nbJoueurs){
            throw new NbJoueursIncorrectsException("Nombre de joueurs atteints pour cette partie ("+nbJoueurs+") : "+nouveauJoueur);
        }
        if (etat!=EtatPartie.INITIALISATION){
            throw new IllegalStateException("Impossible d'ajouter un joueur : la partie n'est plus en état d'initialisation");
        }
        if (isNomDejaExistantParmiJoueursInsensiblementCasse(nouveauJoueur.getNom())){
            throw new IdJoueurIncorrectException("L'id "+nouveauJoueur.getNom()+" du nouveau joueur est déjà utilisé");
        }
        joueurs.add(nouveauJoueur);
        return this;
    }

    public boolean isNomDejaExistantParmiJoueursInsensiblementCasse(String nom) {
        return joueurs.stream().map(Joueur::getNom).map(String::toLowerCase).filter(nom::equals).count()>0;
    }

    public boolean isTousLesJoueursPresent() {
        return joueurs.size()==nbJoueurs;
    }

    public Partie debuterPartie() {
        etat=EtatPartie.EN_COURS;
        joueurs= Collections.unmodifiableList(joueurs);
        return this;
    }

}
