package secret.model;

import lombok.*;
import secret.model.exceptions.IdJoueurIncorrectException;
import secret.utils.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Getter
@Setter
@ToString(of = "nom")
@EqualsAndHashCode(of="nom")
public class Joueur {

    private static String regexNom="[a-zA-Z0-9éèêàôûîâù_]+";
    private static Pattern patternNom=Pattern.compile(regexNom);

    /**
     * Est un identifiant du joueur. Doit respecter certaines règles...
     * Le nom doit respecter le pattern suivant :
     */
    private String nom;

    /**
     * SI le joueur est mort, il ne peut plus participer à aucune action de la partie.
     */
    private EtatJoueur etat;

    /**
     * Le rôle secret du joueur qui contien aussi son allegeance
     */
    @Getter
    private RoleSecret roleSecret;

    /**
     * Correspond à la main du joueur lorsqu'il est ministre ou directeur et qu'il a
     * des proclamations en main
     */
    private List<Proclamation> main=new ArrayList<>();

    public Joueur(@NonNull  String nom) throws IdJoueurIncorrectException {
        verifiersyntaxeNomCorrecteSinonException(nom);
        etat=EtatJoueur.ATTENTE_ROLE;
    }

    public static void verifiersyntaxeNomCorrecteSinonException(@NonNull String nom) throws IdJoueurIncorrectException {
        if (! patternNom.matcher(nom).matches()){
            throw new IdJoueurIncorrectException("L'identifiant \""+nom+"\" fourni pour créer un joueur ne respecte pas le pattern "+regexNom);
        }
    }


    /**
     * <h3>Méthode qui modifie l'instance</h3>
     * Extrait les deux premières proclamation dans la main du joueur :
     * les deux premières proclamations de main (rang 0 et 1) sont supprimées
     * de la liste et retournées.
     * @return une liste constituée par [main[0], main[1]]. liste vide si main est vide
     * ou bien si main.size<2
     */
    public List<Proclamation> extraireDeuxPremieresProclamations() {
        List<Proclamation> retour=new ArrayList<>();
        if(main!=null && main.size()>=2){
            BeanUtils.repeat(retour, l -> l.add(main.remove(0)), 2);
        }
        return retour;
    }

    /**
     * L'attribution du role secret fixe aussi l'allégeance qui en dépend.
     * Change l'état du joueur
     * @param roleSecret la valeur affectée à this.roleSecret
     */
    public void setRoleSecret(@NonNull RoleSecret roleSecret){
        this.roleSecret=roleSecret;
        etat=EtatJoueur.PRET;
    }

    /**
     * Wraper pour accéder à l'alégeance qui est dans le role secret
     * @return roleSecret==null?null:roleSecret.alegeance
     */
    public Alegeance getAlegeance(){
        return roleSecret==null?null:roleSecret.getAlegeance();
    }
}
