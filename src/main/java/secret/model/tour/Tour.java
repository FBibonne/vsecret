package secret.model.tour;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import secret.model.Joueur;
import secret.model.PileProclamations;
import secret.model.Proclamation;

import java.util.List;

/**
 * Entité représentant un tour de jeu. Il est identifié par son rang (
 * 1er tour, 2ème tour, ...)
 * <br/>
 * Un tour regroupe les séquence de jeu suivantes :
 * <ol>
 *  <li>Désignation du candidat ministre (par l'outil)</li>
 *  <li>Proposition d'un candidat Directeur associé</li>
 *  <li>Election puis éventuellement retour à l'étape 1</li>
 *  <li>Session legislative
 *  <ul>
 *    <li>Distribution de 3 cartes proclamation au ministre</li>
 *    <li>Choix de 2 cartes Proclamation pour le Directeur par le ministre</li>
 *  </ul>
 *  </li>
 *  <li>Action exécutive : Choix d'une proclamation par le directeur</li></li>
 *  <li>Eventuellement application d'un pouvoir par le ministre de la magie</li>
 * </ol>
 *
 *
 */
public class Tour {

    /**
     * Rang du tour dans la partie
     */
    private int id;

    /**
     * Cohérence etat / directeur / ministre :
     * etat==SESSION_LEGISLATIVE => ministre !=null ET directeur !=null
     */
    @Getter
    @Setter
    private EtatTour etat;

    private int nbElectionsRealisees=0;

    private Proclamation proclamationPromulguee;

    /**
     * Le ministre elu.
     * <br/>
     * NB : vérifier la cohérence avec etat : etat==SESSION_LEGISLATIVE => ministre !=null
     * => pas de setter
     *
     */
    @Getter
    @Setter
    private Joueur ministre =null;

    /**
     * Le directeur elu.
     * <br/>
     * NB : vérifier la cohérence avec etat : etat==SESSION_LEGISLATIVE => directeur !=null
     * => pas de setter
     *
     */
    @Getter
    @Setter
    private Joueur directeur=null;

    @Getter
    private PileProclamations pileProclamations;

    /**
     * Désigne l'instance d'élection qui est en cours de réalisation :
     * les votes des joueurs adressés à ce tour sont placés dans cette
     * instance d'élection
     */
    private Election electionCourante;

    @Getter
    @Setter
    private boolean defausseDejaEffectuee=false;

    /**
     *
     * @return ministreElu!=null
     */
    public boolean hasMinistreElu() {
        return ministre != null;
    }


    /**
     * Indique si une session legislative est en cours.
     * <br/>
     * si renvoie true alors ministre et directeur sont non null pour le tour courant
     * @return etat==EtatTour.SESSION_LEGISLATIVE
     */
    public boolean isSessionLegislative() {
        return etat==EtatTour.SESSION_LEGISLATIVE;
    }

    /**
     * Wrapper pour obtenir la main du ministre élu du tour.
     * @return ministre==null?null:ministre.main
     */
    public List<Proclamation> getMainDuMinstreElu() {
        return ministre==null?null:ministre.getMain();
    }


    /**
     * Pour connaître le Joueur qui est actuellement désigné
     * comme candidat ministre.
     * @return le joueur actuellement désigné comme candidat ministre.
     * null s'il n'y en pas ou bien si le vote a eu lieu
     */
/*    public Joueur getCandidatMinistreCourant() {

    }*/

    /**
     * Pour connaître le Joueur qui est actuellement désigné
     * comme candidat directeur.
     * @return le joueur actuellement désigné comme candidat directeur.
     * null s'il n'y en pas ou bien si le vote a eu lieu
     */
/*    public Joueur getCandidatDirecteurCourant(){

    }*/
}
