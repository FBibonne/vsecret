package secret.model.exceptions;

import lombok.NonNull;

public class OperationInterditeParEtatException extends SecretMetierException {
    public <E extends Enum<E>> OperationInterditeParEtatException(@NonNull E etat) {
        this(etat, null);
    }

    public <E extends Enum<E>> OperationInterditeParEtatException(@NonNull E etat, String s) {
        super("Opération interdite pour "+nomEntite(etat)+" dont l'état est "+etat+(s==null?"":(" | "+s)));
    }

    private static <E extends Enum<E>> String nomEntite(E etat) {
        return etat.getClass().getSimpleName().replace("Etat", "");
    }
}
