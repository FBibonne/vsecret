package secret.services;

import lombok.NonNull;
import secret.model.Partie;
import secret.model.Proclamation;
import secret.model.tour.SessionLegislative;
import secret.model.tour.Tour;
import secret.model.exceptions.MinistreNePossedePasDefausseException;

public interface TourServices {

    public boolean verifierEndolorisJouable(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

    public boolean verifierAvadaKedavraJouable(@NonNull Pouvoir pouvoir, @NonNull Tour tour);

    public void setProclamationServices(ProclamationServices proclamationServices);

    /**
     * Méthode qui vérifie que le ministre du tour passé en paramètre a bien en main une proclamation égale à
     * le proclamation passée en paramètre.
     * Si ce n'est pas le cas, la méthode lève une exsception sinon ne fait rien
     *
     * @param tour : on regarde la main de ministre.tour. Si un des champs est null, ne fait rien
     * @param proclamation
     */
    public void verifierMinistrePossedeProclamationDefausseeSinonException(@NonNull Tour tour, @NonNull Proclamation proclamation) throws MinistreNePossedePasDefausseException;

    /**
     * Méthode qui transmet du ministre au directeur les deux proclamations qui restent dans la main du ministre :
     * les deux premières proclamations de la main du ministre lui sont retirées et affectées à la main du directeur.
     * <br/>
     * Si le ministre ou le directeur est null, ne fait rien.
     * <br/>
     * Si ministre.main est null ou ministre.main.size<2, affecte une liste vide dans la main du directeur
     * @param tour : le tour contenant le ministre et le directeur élu concernés par le transfert
     * @return le tour ainsi modifié.
     */
    Tour ministreTransmetDeuxProclamationAuDirecteur(Tour tour);

    /**
     * Initie une nouvelle élection si aucune n'est déjà en cours....
     * Désigne automatiquement le candidat ministre pour l'élection à venir
     *
     * @param tour
     * @return le tour avec l'élection dedans
     */
    public Tour commencerElection(@NonNull Tour tour);

    public Tour commencerSessionLegistlative(@NonNull Tour tour);

    public Tour commencerNouveauTour(@NonNull Tour tourTermine);

    public Tour commencerPremierTour(@NonNull Partie partie);
}
