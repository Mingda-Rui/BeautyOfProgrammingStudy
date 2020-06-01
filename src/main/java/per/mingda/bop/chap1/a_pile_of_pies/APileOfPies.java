package per.mingda.bop.chap1.a_pile_of_pies;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class APileOfPies {

    PieFlipper pieFlipper;
    List<Integer> pies;

    public APileOfPies(int numberOfPies) {
        this.pieFlipper = new PieFlipper();
        this.pies = IntStream.range(0, numberOfPies).boxed().collect(Collectors.toList());
        Collections.shuffle(pies);
    }

    public APileOfPies(int[] aPileOfPies) {
        this.pieFlipper = new PieFlipper();
        this.pies = Arrays.stream(aPileOfPies).boxed().collect(Collectors.toList());
    }

    public void setPies(List<Integer> pies) {
        this.pies = pies;
    }

    @Override
    public String toString() {
        return this.pies.toString();
    }

    public int getPileSize() {
        return this.pies.size();
    }

    public int[] getShuffledPies(int numberOfPies) {
        int[] pies = IntStream.range(0, numberOfPies).toArray();
        shuffleArray(pies);
        return pies;
    }

    private void shuffleArray(int[] arr) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; i++) {
            int newIndex = rnd.nextInt(i + 1);
            // simple swap
            int a = arr[newIndex];
            arr[newIndex] = arr[i];
            arr[i] = a;
        }
    }

    public void sortPies() {
        this.pieFlipper.sortPies(this.pies);
    }

    public int getFlipCounter() {
        return this.pieFlipper.getFlipCounter();
    }

    protected void setFlipCounter(int num) {
        this.pieFlipper.setFlipCounter(num);
    }

    public static void main(String ... args) {
        APileOfPies pies = new APileOfPies(10);
        System.out.println("shuffled pies: " + pies);

        pies.sortPies();
        System.out.println("sorted pies: " + pies);

        System.out.println(String.format("flipped: %d times", pies.getFlipCounter()));
    }
}
