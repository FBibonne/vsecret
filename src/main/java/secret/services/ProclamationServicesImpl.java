package secret.services;

import lombok.NonNull;
import secret.model.PileProclamations;
import secret.model.Proclamation;

import java.util.List;

public class ProclamationServicesImpl implements ProclamationServices {


    public List<Proclamation> tirage(@NonNull PileProclamations pileProclamations) {

        if (pileProclamations.taille()<3){
            pileProclamations.rebattre();
        }
        return pileProclamations.prendreTroisPremieresCartes();
    }
}
