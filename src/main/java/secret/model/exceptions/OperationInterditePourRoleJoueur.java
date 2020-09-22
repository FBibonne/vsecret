package secret.model.exceptions;

import lombok.NonNull;
import secret.model.Joueur;

public class OperationInterditePourRoleJoueur extends Exception {

    public OperationInterditePourRoleJoueur(@NonNull Joueur joueur, String message) {
        super("Le joueur "+joueur.getNom()+" n'a pas le role nécessaire pour effectuer l'opération | "+message);
    }


}
