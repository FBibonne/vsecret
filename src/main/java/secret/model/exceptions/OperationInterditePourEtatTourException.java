package secret.model.exceptions;

import secret.model.tour.EtatTour;

public class OperationInterditePourEtatTourException extends DefausseException {
    public OperationInterditePourEtatTourException(EtatTour etat) {
        this(etat, null);
    }

    public OperationInterditePourEtatTourException(EtatTour etat, String s) {
        super("Opération interdite pour le tour courant dont l'état est "+etat+(s==null?"":(" | "+s)));
    }
}
