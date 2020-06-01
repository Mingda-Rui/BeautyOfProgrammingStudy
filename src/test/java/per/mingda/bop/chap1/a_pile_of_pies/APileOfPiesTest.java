package per.mingda.bop.chap1.a_pile_of_pies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class APileOfPiesTest {

    @Test
    public void getPieRandomOrderTest() {
        int numberOfPies = 5;
        APileOfPies testPies = new APileOfPies(numberOfPies);
        assertEquals(numberOfPies, testPies.getPileSize());

        int[] piesArray = new int[] {1, 2, 3, 4};
        APileOfPies testPies2 = new APileOfPies(piesArray);
        assertEquals(piesArray.length, testPies2.getPileSize());
    }

    @Test
    public void sortPiesTest() {
        int[] testPieArray = new int[] {4, 3, 2, 8, 9, 10, 3, 7, 1};
        APileOfPies testPies = new APileOfPies(testPieArray);
        testPies.sortPies();
        int[] expect = new int[] {10, 9, 8, 7, 4, 3, 3, 2, 1};
        assertArrayEquals(expect, testPies.getPies());
        assertEquals(10, testPies.getFlipCount());

        testPieArray = new int[] {1, 2, 3, 4, 5};
        testPies = new APileOfPies(testPieArray);
        testPies.sortPies();
        expect = new int[] {5, 4, 3, 2, 1};
        assertArrayEquals(expect, testPies.getPies());
        assertEquals(1, testPies.getFlipCount());

        testPieArray = new int[] {5, 4, 3, 2, 1};
        testPies = new APileOfPies(testPieArray);
        testPies.sortPies();
        expect = new int[] {5, 4, 3, 2, 1};
        assertArrayEquals(expect, testPies.getPies());
        assertEquals(0, testPies.getFlipCount());

        testPieArray = new int[] {3, 3, 3};
        testPies = new APileOfPies(testPieArray);
        testPies.sortPies();
        expect = new int[] {3, 3, 3};
        assertArrayEquals(expect, testPies.getPies());
        assertEquals(0, testPies.getFlipCount());

        testPieArray = new int[] {};
        testPies = new APileOfPies(testPieArray);
        testPies.sortPies();
        expect = new int[] {};
        assertArrayEquals(expect, testPies.getPies());
        assertEquals(0, testPies.getFlipCount());
    }
}
