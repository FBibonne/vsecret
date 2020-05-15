package secret.utils;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MathsUtilsTest {

    @Test
    void genererProducteurAleasDistincts_iteratorShouldRaiseException() {
        assertThrows(NoSuchElementException.class,()->MathsUtils.genererProducteurAleasDistincts(0).next());
    }

    @Test
    void genererProducteurAleasDistincts_iteratorShouldSuply5DistinctDouble() {
        Iterator<Double> iterateur=MathsUtils.genererProducteurAleasDistincts(5);
        Set<Double> reponses=new HashSet<>();
        for (int i = 1; i <=5 ; i++) {
            reponses.add(iterateur.next());
        }
        assertEquals(5, reponses.size());
    }
}