package per.mingda.bop.chap1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class APileOfPancakeTest {

    static APileOfPancake cakesProblem;

    @BeforeAll
    public static void init() {
        cakesProblem = new APileOfPancake();
    }

    @Test
    public void getPancakeRandomOrderTest() {
        int numberOfPancakes = 5;
        int[] randomOrderPancakes = cakesProblem.getShuffledPancakes(numberOfPancakes);
        assertEquals(numberOfPancakes, randomOrderPancakes.length);
    }

    @Test
    public void sortPancakesTest() {

    }

    @Test
    public void sortPancakesTest2() {

    }

    @Test
    public void getLargestPancakesPosTest() {
        int[] testPancakes = new int[] {1, 2, 3, 4, 5, 6};
        int largestPancakePos = cakesProblem.getLargestPancakesPos(testPancakes);
        assertEquals(5, largestPancakePos);

        testPancakes = new int[] {1, 2, 3, 6, 5, 4};
        largestPancakePos = cakesProblem.getLargestPancakesPos(testPancakes);
        assertEquals(3, largestPancakePos);

        testPancakes = new int[] {6, 2, 3, 1, 5, 4};
        largestPancakePos = cakesProblem.getLargestPancakesPos(testPancakes);
        assertEquals(0, largestPancakePos);

        testPancakes = new int[] {6, 2, 3, 6, 5, 4};
        largestPancakePos = cakesProblem.getLargestPancakesPos(testPancakes);
        assertEquals(0, largestPancakePos);

        testPancakes = new int[] {1};
        largestPancakePos = cakesProblem.getLargestPancakesPos(testPancakes);
        assertEquals(0, largestPancakePos);

        testPancakes = new int[] {};
        largestPancakePos = cakesProblem.getLargestPancakesPos(testPancakes);
        assertEquals(0, largestPancakePos);
    }

    @Test
    public void flipPancakeToTopTest() {
        cakesProblem.setFlipCounter(0);
        LinkedList<Integer> testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5});
        cakesProblem.flipPancakesToTop(testPancakes, 2);
        int[] expect = new int[] {1, 2, 5, 4, 3};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(1, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5});
        cakesProblem.flipPancakesToTop(testPancakes, 4);
        expect = new int[] {1, 2, 3, 4, 5};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(0, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1});
        cakesProblem.flipPancakesToTop(testPancakes, 0);
        expect = new int[] {1};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(0, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {});
        cakesProblem.flipPancakesToTop(testPancakes, 0);
        expect = new int[] {};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(0, cakesProblem.getFlipCounter());
    }

    @Test
    public void flipAllPancakesTest() {
        cakesProblem.setFlipCounter(0);
        LinkedList<Integer> testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5, 6});
        cakesProblem.flipAllPancakes(testPancakes);
        int[] expect = new int[] {6, 5, 4, 3, 2, 1};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(1, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1});
        cakesProblem.flipAllPancakes(testPancakes);
        expect = new int[] {1};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(0, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {});
        cakesProblem.flipAllPancakes(testPancakes);
        expect = new int[] {};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(0, cakesProblem.getFlipCounter());
    }

    @Test
    public void flipPancakeToButtonTest() {
        cakesProblem.setFlipCounter(0);
        LinkedList<Integer> testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5, 6});
        cakesProblem.flipPancakeToButton(testPancakes, 2);
        int[] expect = new int[] {3, 4, 5, 6, 2, 1};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(2, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5, 6});
        cakesProblem.flipPancakeToButton(testPancakes, 5);
        expect = new int[] {6, 5, 4, 3, 2, 1};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(1, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5, 6});
        cakesProblem.flipPancakeToButton(testPancakes, 0);
        expect = new int[] {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(0, cakesProblem.getFlipCounter());
    }

    @Test
    public void flipPancakesTest() {
        cakesProblem.setFlipCounter(0);
        LinkedList<Integer> testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5, 6});
        cakesProblem.flipPancakes(testPancakes, 2, 5);
        int[] expect = new int[] {1, 2, 5, 4, 3, 6};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(1, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5});
        cakesProblem.flipPancakes(testPancakes, 1, 5);
        expect = new int[] {1, 5, 4, 3, 2};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(1, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5});
        cakesProblem.flipPancakes(testPancakes, 1, 2);
        expect = new int[] {1, 2, 3, 4, 5};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(1, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5});
        cakesProblem.flipPancakes(testPancakes, 3, 3);
        expect = new int[] {1, 2, 3, 4, 5};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(0, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1, 2, 3, 4, 5});
        cakesProblem.flipPancakes(testPancakes, 2, 10);
        expect = new int[] {1, 2, 5, 4, 3};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(1, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {1});
        cakesProblem.flipPancakes(testPancakes, 0, 0);
        expect = new int[] {1};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(0, cakesProblem.getFlipCounter());

        cakesProblem.setFlipCounter(0);
        testPancakes = generateTestPancakes(new int[] {});
        cakesProblem.flipPancakes(testPancakes, 0, 0);
        expect = new int[] {};
        assertArrayEquals(expect, toIntArray(testPancakes));
        assertEquals(0, cakesProblem.getFlipCounter());
    }

    @Test
    public void flipPancakesThrowExTest() {
        var testPancakes = generateTestPancakes(new int[] {1, 2, 3});

        // lower boundary > upper boundary throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->  cakesProblem.flipPancakes(testPancakes, 2, 1));
        // lower boundary >= pancakes size throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->  cakesProblem.flipPancakes(testPancakes, 3, 4));
    }

    private int[] toIntArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private LinkedList<Integer> generateTestPancakes(int[] pancakes) {
        return Arrays.stream(pancakes)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
