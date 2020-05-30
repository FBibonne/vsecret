package secret.model.tour;

import lombok.Getter;
import secret.model.Joueur;

@Getter
public class Election {

    private EtatElection etat;
    /**
     * Lorsque que l'état de l'élection est à ELU, cet attribut est non null
     */
    private Joueur ministreElu;

    /**
     * Lorsque que l'état de l'élection est à ELU, cet attribut est non null
     */

    private Joueur directeurElu;
}
