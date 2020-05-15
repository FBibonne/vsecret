package secret.model;

import lombok.AccessLevel;
import lombok.Getter;
import secret.utils.MathsUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Cette classe représente la pile de cartes proclamation
 * associée à un jeu. On prend les cartes dans cette pile au
 * fur et à mesure des tours. Lorsque la pile n'a plus la taille
 * suffisante les cartes sont rebattues et la pile est reconstituée.
 *
 * Rebattre les cartes ne détruit pas cette instance mais recrée une
 * nouvelle liste de Proclamation ordonnées aléatoirement
 */
public class PileProclamations {

    public static final int NOMBRE_MANGE_MORT=11;
    public static final int NOMBRE_ORDRE_DU_PHOENIX=6;

    @Getter(AccessLevel.PROTECTED)
    private List<Proclamation> pileDeProclamations=new ArrayList<>();

    public PileProclamations(){
        rebattre();
    }

    /**
     * Retourne la taille courante de la pile (le nombre de cartes qu'il reste)
     * @return un entier positif
     */
    public int taille() {
        return pileDeProclamations.size();
    }

    /**
     *  Regénère une nouvelle pile de cartes en mélengeant aléatoirement 11 proclamations
     * MANGEMORT et 6 proclamations OrdreDuPhoenix.
     * La taille courante de la pile est ramenée à 17.
     * A la création de l'instance les cartes sont rebattues pour constituer une première pile
     *
     *  //TODO utiliser Collections.shuffle
     *
     */
    public void rebattre() {
        Map<Double, Proclamation> proclamationsAvecAleas=new HashMap<>();
        Iterator<Double> aleaProducer= MathsUtils.genererProducteurAleasDistincts(NOMBRE_ORDRE_DU_PHOENIX+NOMBRE_MANGE_MORT);
        proclamationsAvecAleas=ajouterProclamationsAvecAlea(proclamationsAvecAleas, NOMBRE_ORDRE_DU_PHOENIX,Proclamation.ORDRE_DU_PHOENIX, aleaProducer);
        proclamationsAvecAleas=ajouterProclamationsAvecAlea(proclamationsAvecAleas, NOMBRE_MANGE_MORT,Proclamation.MANGE_MORT, aleaProducer);
        pileDeProclamations=trierParAleaCroissant(proclamationsAvecAleas);
    }

    protected List<Proclamation> trierParAleaCroissant(Map<Double, Proclamation> proclamationsAvecAleas) {
        return proclamationsAvecAleas.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).collect(Collectors.toList());
    }

    protected Map<Double, Proclamation> ajouterProclamationsAvecAlea(Map<Double, Proclamation> proclamationsAvecAleas, int nbAjouts, Proclamation proclamation,Iterator<Double> aleaProducer) {
        for (int i = 0; i < nbAjouts; i++) {
            proclamationsAvecAleas.put(aleaProducer.next(),proclamation);
        }
        return proclamationsAvecAleas;
    }

    /**
     * Retourne les trois premières cartes de la pile et diminue de 3 la taille de la pile
     *
     * @return 3 proclamations
     *
     * @throws IllegalStateException si la pile contenait moins de 3 cartes
     */
    public List<Proclamation> prendreTroisPremieresCartes() {
        if (pileDeProclamations.size()<3){
            throw new IllegalStateException("La taille de la liste pileDeProclamation ("+pileDeProclamations+") ne permet pas de tirer 3 cartes");
        }
        List<Proclamation> retour=new ArrayList<>();
        for(int i=0;i<3;i++){
            retour.add(pileDeProclamations.get(0));
            pileDeProclamations.remove(0);
        }
        return retour;
    }
}
