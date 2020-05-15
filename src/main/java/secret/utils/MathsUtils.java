package secret.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MathsUtils {

    /**
     * Génère un ensemble de i nombres aléatoires distincts.
     * @param i : le nombre d'aléas distincts à générer
     * @return un itérateur sur les aléas distincts générés
     */
    public static Iterator<Double> genererProducteurAleasDistincts(int i) {
        Set<Double> retour=new HashSet<>();
        while(retour.size()<i){
            retour.add(Math.random());
        }
        return retour.iterator();
    }

}
