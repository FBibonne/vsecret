package secret.model.tour;

import lombok.*;
import secret.model.Joueur;
import secret.model.Proclamation;

/**
 * Cette classe représente la défausse d'une proclamation choisie par le ministre.
 * Lorsque que le ministre choisit sa proclamation à défausser
 * il doit le faire avec un POST dont le corps de requête est une instance de cette classe
 *
 * Cette instance est utilisée par le système pour traiter la défausse d'une proclamation (puis le transfert des deux
 * proclamations restantes dans la main du directeur).
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Defausse {

    @NonNull
    Proclamation proclamation;

    @NonNull
    Joueur defausseur;

}
