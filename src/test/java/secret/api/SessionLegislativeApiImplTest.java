package secret.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import secret.api.tour.SessionLegislativeApiImpl;
import secret.model.*;
import secret.model.exceptions.DefausseException;
import secret.model.exceptions.DefausseurPasMinistreException;
import secret.model.exceptions.MinistreNePossedePasDefausseException;
import secret.model.exceptions.OperationInterditePourEtatTourException;
import secret.model.tour.Defausse;
import secret.model.tour.EtatTour;
import secret.model.tour.Tour;
import secret.services.JoueurServiceImpl;
import secret.services.tour.TourServicesImpl;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SessionLegislativeApiImplTest {

    private SessionLegislativeApiImpl tourApiImpl;
    private Tour tour;
    private Defausse defausse;
    private Joueur ministre =new Joueur();
    private Joueur directeur=new Joueur();

    @BeforeEach
    public void beforeAll(){
        tourApiImpl=new SessionLegislativeApiImpl();
        tourApiImpl.setJoueurService(new JoueurServiceImpl());
        tourApiImpl.setTourServices(new TourServicesImpl());

        tour=new Tour();
        tour.setEtat(EtatTour.SESSION_LEGISLATIVE);
        tour.setMinistre(ministre);
        tour.setDirecteur(directeur);
        tour.getMinistre().setMain(new ArrayList<>(Arrays.asList(Proclamation.ORDRE_DU_PHOENIX, Proclamation.MANGE_MORT, Proclamation.MANGE_MORT)));

        defausse=new Defausse(Proclamation.MANGE_MORT, ministre);
    }

    @Test
    void defausserEtpasserProclamationsAuDirecteur_shouldSuccess() throws DefausseException {
        assertEquals(0, tour.getDirecteur().getMain().size());
        assertEquals(3, tour.getMinistre().getMain().size());
        assertFalse(tour.isDefausseDejaEffectuee());
        tour=tourApiImpl.defausserEtpasserProclamationsAuDirecteur(defausse, tour);
        assertEquals(Arrays.asList(Proclamation.ORDRE_DU_PHOENIX, Proclamation.MANGE_MORT), tour.getDirecteur().getMain());
        assertEquals(true, tour.isDefausseDejaEffectuee());
    }

    @Test
    void defausserEtpasserProclamationsAuDirecteur_shouldRaiseOperationInterdite_withoutLEGISLATIVE() {
        tour.setEtat(EtatTour.ACTION_EXECUTIVE);
        assertThrows(OperationInterditePourEtatTourException.class, ()->tourApiImpl.defausserEtpasserProclamationsAuDirecteur(defausse,tour));
    }

    @Test
    void defausserEtpasserProclamationsAuDirecteur_shouldRaiseOperationInterdite_dejaEffectuee() {
        tour.setDefausseDejaEffectuee(true);
        try {
            tourApiImpl.defausserEtpasserProclamationsAuDirecteur(defausse, tour);
            fail("Pas d'erreur");
        } catch (OperationInterditePourEtatTourException oie) {
            assertEquals("Erreur dans action Defausse : Opération interdite pour le tour courant dont l'état est "+EtatTour.SESSION_LEGISLATIVE+" | defausse déjà effectuée pour ce tour", oie.getMessage());
        } catch (DefausseException de) {
            fail("Mauvaise exception : " + de);
        }
    }

    @Test
    void defausserEtpasserProclamationsAuDirecteur_shouldRaisePasMinistre() {
        defausse.setDefausseur(new Joueur());
        assertThrows(DefausseurPasMinistreException.class, ()->tourApiImpl.defausserEtpasserProclamationsAuDirecteur(defausse,tour));
    }

    @Test
    void defausserEtpasserProclamationsAuDirecteur_shouldRaisePossedePasProclamation() {
        tour.getMinistre().setMain(new ArrayList<>(Arrays.asList(Proclamation.MANGE_MORT, Proclamation.MANGE_MORT, Proclamation.MANGE_MORT)));
        defausse.setProclamation(Proclamation.ORDRE_DU_PHOENIX);
        assertThrows(MinistreNePossedePasDefausseException.class, ()->tourApiImpl.defausserEtpasserProclamationsAuDirecteur(defausse,tour));
    }

}