package secret.services;

import lombok.NonNull;
import secret.model.Alegeance;
import secret.model.Joueur;
import secret.model.Proclamation;

import java.util.List;

public class JoueurServiceImpl implements  JoueurService {

    @Override
    public Joueur defausser(@NonNull Joueur joueur, @NonNull Proclamation proclamation) {
        if (joueur.getMain()!=null){
            joueur.getMain().remove(proclamation);
        }
        return joueur;
    }

    @Override
    public Alegeance findAlegeance(@NonNull String nomJoueur, @NonNull List<Joueur> joueurs) {
        return joueurs.stream().filter(j->nomJoueur.equals(j.getNom())).map(Joueur::getAlegeance).findFirst().orElse(null);
    }
}
