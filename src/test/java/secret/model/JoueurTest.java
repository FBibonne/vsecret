package secret.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void extraireDeuxPremieresProclamations_shouldReturnEmpty() {
        Joueur j=new Joueur();
        assertEquals(new ArrayList<Proclamation>(), j.extraireDeuxPremieresProclamations());
        j.setMain(null);
        assertEquals(new ArrayList<Proclamation>(), j.extraireDeuxPremieresProclamations());
    }

    @Test
    void extraireDeuxPremieresProclamations_shouldReturnCouple() {
        Joueur j=new Joueur();

        j.setMain(new ArrayList<>(Arrays.asList(Proclamation.MANGE_MORT, Proclamation.MANGE_MORT)));
        assertEquals(Arrays.asList(Proclamation.MANGE_MORT, Proclamation.MANGE_MORT), j.extraireDeuxPremieresProclamations());
        assertEquals(new ArrayList<Proclamation>(), j.getMain());

        j.setMain(new ArrayList<>(Arrays.asList(Proclamation.ORDRE_DU_PHOENIX, Proclamation.MANGE_MORT)));
        assertEquals(Arrays.asList(Proclamation.ORDRE_DU_PHOENIX, Proclamation.MANGE_MORT), j.extraireDeuxPremieresProclamations());
        assertEquals(new ArrayList<Proclamation>(), j.getMain());

        j.setMain(new ArrayList<>(Arrays.asList(Proclamation.ORDRE_DU_PHOENIX, Proclamation.MANGE_MORT, Proclamation.ORDRE_DU_PHOENIX)));
        assertEquals(Arrays.asList(Proclamation.ORDRE_DU_PHOENIX, Proclamation.MANGE_MORT), j.extraireDeuxPremieresProclamations());
        assertEquals(Arrays.asList(Proclamation.ORDRE_DU_PHOENIX), j.getMain());

    }
}