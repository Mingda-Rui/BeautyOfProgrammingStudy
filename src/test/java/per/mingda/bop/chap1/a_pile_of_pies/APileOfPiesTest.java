package per.mingda.bop.chap1.a_pile_of_pies;

import org.junit.jupiter.api.Disabled;
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
}
