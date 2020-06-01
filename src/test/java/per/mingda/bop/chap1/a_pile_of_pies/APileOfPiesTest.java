package per.mingda.bop.chap1.a_pile_of_pies;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class APileOfPiesTest {

    @Test
    public void getPancakeRandomOrderTest() {
        int numberOfPancakes = 5;
        APileOfPies testPileOfPies = new APileOfPies(numberOfPancakes);
        assertEquals(numberOfPancakes, testPileOfPies.getPileSize());
    }

    @Disabled
    public void sortPancakesTest() {

    }
}
