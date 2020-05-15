package secret.services;

import lombok.NonNull;
import secret.model.PileProclamations;
import secret.model.Proclamation;

import java.util.List;

public interface ProclamationServices {

    /**
     * Effetcue le tirage de 3 proclamation dans la pile. A partir d'une pile
     * mélengeant aléatoirement 11 proclamantions MangeMort et 6 Proclamations
     * OrdreDuPhoenix, retourne les 3 premières cartes. Si la pile contient moins
     * de 3 cartes, une nouvelle pile est générée (une nouvelle pile est générée au
     * sein de l'instance pileProclamations mais cette instance est conservée)
     *
     * @param l'objet pile dans lequel les 3 Proclamations sont tirées. Si pas
     *         assez de carte dans l'objet pile, les cartes de la pile sont rebattues
     *
     * @return La liste des 3 Proclamations tirées
     */
    public List<Proclamation> tirage(@NonNull PileProclamations pileProclamations);
}
