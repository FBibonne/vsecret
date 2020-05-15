package secret.model;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PileProclamationsTest {

    @Test
    void constructor_shouldInitializeHeapWith17() {
        assertEquals(17, (new PileProclamations()).taille());
    }

    @Test
    void rebattre_shouldChangeOrder_resizeList_respectProportions() {
        PileProclamations pileProclamations = new PileProclamations();
        List<String> premieresCartes = pileProclamations.getPileDeProclamations().stream().map((Proclamation::toString)).collect(Collectors.toList());
        pileProclamations.prendreTroisPremieresCartes();
        pileProclamations.rebattre();
        assertEquals(PileProclamations.NOMBRE_MANGE_MORT, pileProclamations.getPileDeProclamations().stream().filter(Proclamation.MANGE_MORT::equals).count());
        assertEquals(PileProclamations.NOMBRE_ORDRE_DU_PHOENIX, pileProclamations.getPileDeProclamations().stream().filter(Proclamation.ORDRE_DU_PHOENIX::equals).count());
        assertEquals(17, pileProclamations.taille());
        assertNotEquals(premieresCartes, pileProclamations.getPileDeProclamations().stream().map((Proclamation::toString)).collect(Collectors.toList()));
    }

    @Test
    void trierParAleaCroissant() {
        PileProclamations pileProclamations = new PileProclamations();
        Map<Double, Proclamation> proclamationMap = new HashMap<>();

        proclamationMap.put(0.4308078910279365, Proclamation.MANGE_MORT);
        proclamationMap.put(0.17159259177024877, Proclamation.MANGE_MORT);
        proclamationMap.put(0.9663410530321678, Proclamation.MANGE_MORT);
        proclamationMap.put(0.8346751843134916, Proclamation.MANGE_MORT);
        proclamationMap.put(0.28062694469262917, Proclamation.MANGE_MORT);
        proclamationMap.put(0.6674687970795989, Proclamation.MANGE_MORT);
        proclamationMap.put(0.939648825012292, Proclamation.MANGE_MORT);
        proclamationMap.put(0.2942851914202752, Proclamation.MANGE_MORT);
        proclamationMap.put(0.30824694717502743, Proclamation.MANGE_MORT);
        proclamationMap.put(0.39246249268003186, Proclamation.MANGE_MORT);
        proclamationMap.put(0.8987584210920627, Proclamation.MANGE_MORT);
        proclamationMap.put(0.05765219025729118, Proclamation.ORDRE_DU_PHOENIX);
        proclamationMap.put(0.08561890872011246, Proclamation.ORDRE_DU_PHOENIX);
        proclamationMap.put(0.8013840853484864, Proclamation.ORDRE_DU_PHOENIX);
        proclamationMap.put(0.9345322782340515, Proclamation.ORDRE_DU_PHOENIX);
        proclamationMap.put(0.7158103874580511, Proclamation.ORDRE_DU_PHOENIX);
        proclamationMap.put(0.15711638353803314, Proclamation.ORDRE_DU_PHOENIX);
        List<Proclamation> proclamationsTriees=pileProclamations.trierParAleaCroissant(proclamationMap);
        List<Proclamation> triAttendu= Arrays.asList(
                Proclamation.ORDRE_DU_PHOENIX,
                Proclamation.ORDRE_DU_PHOENIX,
                Proclamation.ORDRE_DU_PHOENIX,
                Proclamation.MANGE_MORT,
                Proclamation.MANGE_MORT,
                Proclamation.MANGE_MORT,
                Proclamation.MANGE_MORT,
                Proclamation.MANGE_MORT,
                Proclamation.MANGE_MORT,
                Proclamation.MANGE_MORT,
                Proclamation.ORDRE_DU_PHOENIX,
                Proclamation.ORDRE_DU_PHOENIX,
                Proclamation.MANGE_MORT,
                Proclamation.MANGE_MORT,
                Proclamation.ORDRE_DU_PHOENIX,
                Proclamation.MANGE_MORT,
                Proclamation.MANGE_MORT);
        assertEquals(triAttendu, proclamationsTriees);
    }

    @Test
    void prendreTroisPremieresCartes_shouldReturnBeginningOfListAndDecreaseSize() {
        PileProclamations pileProclamations = new PileProclamations();
        int sizeDecreased = pileProclamations.taille() - 3;

        List<Proclamation> troisPremieresCartes = new ArrayList<>(pileProclamations.getPileDeProclamations().subList(0, 3));
        assertEquals(troisPremieresCartes, pileProclamations.prendreTroisPremieresCartes());
        assertEquals(sizeDecreased, pileProclamations.taille());
    }

    @Test
    void prendreTroisPremieresCartes_whenNotEnoughCards_shouldRaiseIllegalStateException() {
        PileProclamations pileProclamations = new PileProclamations();
        for (int i = 1; i <= 5; i++) {
            pileProclamations.prendreTroisPremieresCartes();
        }
        assertThrows(IllegalStateException.class, pileProclamations::prendreTroisPremieresCartes);
    }


}