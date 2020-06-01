package per.mingda.bop.chap1.a_pile_of_pies;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PieFlipperTest {

    static PieFlipper pf;

    @BeforeAll
    public static void init() {
        pf = new PieFlipper();
    }

    @Disabled
    public void sortPiesTest() {

    }

    @Test
    public void getLargestPiesPosTest() {
        List<Integer> testPies = Arrays.asList(1, 2, 3, 4, 5, 6);
        int largestPiePos = pf.getLargestPiesPos(testPies);
        assertEquals(5, largestPiePos);

        testPies = Arrays.asList(1, 2, 3, 6, 5, 4);
        largestPiePos = pf.getLargestPiesPos(testPies);
        assertEquals(3, largestPiePos);

        testPies = Arrays.asList(6, 2, 3, 1, 5, 4);
        largestPiePos = pf.getLargestPiesPos(testPies);
        assertEquals(0, largestPiePos);

        testPies = Arrays.asList(6, 2, 3, 6, 5, 4);
        largestPiePos = pf.getLargestPiesPos(testPies);
        assertEquals(0, largestPiePos);

        testPies = Collections.singletonList(1);
        largestPiePos = pf.getLargestPiesPos(testPies);
        assertEquals(0, largestPiePos);

        testPies = Collections.emptyList();
        largestPiePos = pf.getLargestPiesPos(testPies);
        assertEquals(0, largestPiePos);
    }

    @Test
    public void flipPieToTopTest() {
        pf.setFlipCount(0);
        List<Integer> testPies = Arrays.asList(1, 2, 3, 4, 5);
        pf.flipPiesToTop(testPies, 2);
        int[] expect = new int[] {1, 2, 5, 4, 3};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(1, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Arrays.asList(1, 2, 3, 4, 5);
        pf.flipPiesToTop(testPies, 4);
        expect = new int[] {1, 2, 3, 4, 5};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(0, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Collections.singletonList(1);
        pf.flipPiesToTop(testPies, 0);
        expect = new int[] {1};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(0, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Collections.emptyList();
        pf.flipPiesToTop(testPies, 0);
        expect = new int[] {};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(0, pf.getFlipCount());
    }

    @Test
    public void flipAllPiesTest() {
        pf.setFlipCount(0);
        List<Integer> testPies = Arrays.asList(1, 2, 3, 4, 5, 6);
        pf.flipAllPies(testPies);
        int[] expect = new int[] {6, 5, 4, 3, 2, 1};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(1, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Collections.singletonList(1);
        pf.flipAllPies(testPies);
        expect = new int[] {1};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(0, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Collections.emptyList();
        pf.flipAllPies(testPies);
        expect = new int[] {};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(0, pf.getFlipCount());
    }

    @Test
    public void flipPieToButtonTest() {
        pf.setFlipCount(0);
        List<Integer> testPies = Arrays.asList(1, 2, 3, 4, 5, 6);
        pf.flipPieToButton(testPies, 2);
        int[] expect = new int[] {3, 4, 5, 6, 2, 1};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(2, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Arrays.asList(1, 2, 3, 4, 5, 6);
        pf.flipPieToButton(testPies, 5);
        expect = new int[] {6, 5, 4, 3, 2, 1};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(1, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Arrays.asList(1, 2, 3, 4, 5, 6);
        pf.flipPieToButton(testPies, 0);
        expect = new int[] {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(0, pf.getFlipCount());
    }

    @Test
    public void flipPiesTest() {
        pf.setFlipCount(0);
        List<Integer> testPies = Arrays.asList(1, 2, 3, 4, 5, 6);
        pf.flipPies(testPies, 2, 5);
        int[] expect = new int[] {1, 2, 5, 4, 3, 6};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(1, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Arrays.asList(1, 2, 3, 4, 5);
        pf.flipPies(testPies, 1, 5);
        expect = new int[] {1, 5, 4, 3, 2};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(1, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Arrays.asList(1, 2, 3, 4, 5);
        pf.flipPies(testPies, 1, 2);
        expect = new int[] {1, 2, 3, 4, 5};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(1, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Arrays.asList(1, 2, 3, 4, 5);
        pf.flipPies(testPies, 3, 3);
        expect = new int[] {1, 2, 3, 4, 5};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(0, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Arrays.asList(1, 2, 3, 4, 5);
        pf.flipPies(testPies, 2, 10);
        expect = new int[] {1, 2, 5, 4, 3};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(1, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Collections.singletonList(1);
        pf.flipPies(testPies, 0, 0);
        expect = new int[] {1};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(0, pf.getFlipCount());

        pf.setFlipCount(0);
        testPies = Collections.emptyList();
        pf.flipPies(testPies, 0, 0);
        expect = new int[] {};
        assertArrayEquals(expect, toIntArray(testPies));
        assertEquals(0, pf.getFlipCount());
    }

    @Test
    public void flipPiesThrowExTest() {
        var testPies = Arrays.asList(1, 2, 3);

        // lower boundary > upper boundary throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->  pf.flipPies(testPies, 2, 1));
        // lower boundary >= pies size throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->  pf.flipPies(testPies, 3, 4));
    }

    private int[] toIntArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
