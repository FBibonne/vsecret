package secret.model.tour;

import lombok.Getter;
import lombok.NonNull;
import secret.model.Joueur;

@Getter
public class Election {

    private EtatElection etat;

    private int nbScrutinsRealises;

    @NonNull
    private FournisseurProchainCandidatMinistre fournisseurProchainCandidatMinistre;

    /**
     * Lorsque que l'état de l'élection est à ELU, cet attribut est non null
     */
    private Joueur ministreElu;

    /**
     * Lorsque que l'état de l'élection est à ELU, cet attribut est non null
     */

    private Joueur directeurElu;

    private Joueur ministreCandidat;

    private Joueur directeurCandidat;

    public Election(@NonNull  FournisseurProchainCandidatMinistre fournisseurProchainCandidatMinistre){
        this.fournisseurProchainCandidatMinistre=fournisseurProchainCandidatMinistre;
        etat=EtatElection.EN_COURS;
        nbScrutinsRealises=0;
        ministreElu=null;
        directeurElu=null;
        directeurCandidat=null;
        commencerNouveauScrutin();
    }

    public void commencerNouveauScrutin(){
        etat=EtatElection.EN_COURS;
        ministreCandidat=fournisseurProchainCandidatMinistre.suivant();
    }
}
