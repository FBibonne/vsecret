package secret.model.tour;

import lombok.NonNull;
import secret.model.Joueur;

import java.util.List;

/**
 * Classe qui calcule le prochain ministre candidat à
 * partir d'un liste de joueurs.
 * Lors de l'instation, la classe calcule au hasard un premier
 * candidat et fournit ensuite le candidat suivant à chaque
 * appel de suivant comme un curseur.
 */
public class FournisseurProchainCandidatMinistre {

    @NonNull
    private List<Joueur> joueurs;

    private Integer rangProchainCandidat;

    public FournisseurProchainCandidatMinistre(@NonNull List<Joueur> joueurs){
        verifierListeEstUnmodifiableSinonException(joueurs);
        this.joueurs=joueurs;
        rangProchainCandidat=Double.valueOf(Math.random()*(joueurs.size()-1)).intValue();
    }

    private void verifierListeEstUnmodifiableSinonException(List<Joueur> joueurs) {
        boolean unsupportedOk=false;
        try{
            joueurs.add(joueurs.get(0));
        }catch (UnsupportedOperationException uoe){
            unsupportedOk=true;
        }
        throw new Error("La liste des joueurs fournie au constructeur FournisseurProchainCandidatMinistre est mutable");
    }

    public Joueur suivant() {
        Joueur retour = joueurs.get(rangProchainCandidat);
        rangProchainCandidat = (rangProchainCandidat + 1) % joueurs.size();
        return retour;
    }

}
