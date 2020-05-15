package secret.model.exceptions;

import lombok.NonNull;
import secret.model.Joueur;

public class DefausseurPasMinistreException extends DefausseException {
    public DefausseurPasMinistreException(@NonNull Joueur defausseur, Joueur ministre) {
        super("le defausseur ("+defausseur+") n'est pas le ministre du tour("+ministre+")");
    }
}
