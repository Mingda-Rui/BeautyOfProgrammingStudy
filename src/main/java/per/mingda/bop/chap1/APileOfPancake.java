package per.mingda.bop.chap1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class APileOfPancake {

    int flipCounter = 0;

    public int[] getShuffledPancakes(int numberOfPancakes) {
        int[] pancakes = IntStream.range(0, numberOfPancakes).toArray();
        shuffleArray(pancakes);
        return pancakes;
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

    public void sortPancakes(int[] pancakes) {
        List<Integer> linkedPancakes = Arrays.stream(pancakes)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        List<Integer> sortedPancakes = this.sortPancakes(linkedPancakes);

        int[] sortedPancakeArray = sortedPancakes.stream().mapToInt(Integer::intValue).toArray();
        System.arraycopy(sortedPancakeArray, 0, pancakes, 0, sortedPancakeArray.length);
    }

    protected List<Integer> sortPancakes(List<Integer> pancakes) {
        if (pancakes.size() <= 1) return pancakes;

        int posOfLargestPancakes = getLargestPancakesPos(pancakes);
        flipPancakeToButton(pancakes, posOfLargestPancakes);

        List<Integer> pancakesExcludeBottom = pancakes.subList(1, pancakes.size());
        sortPancakes(pancakesExcludeBottom);
        return pancakes;
    }

    protected int getLargestPancakesPos(List<Integer> pancakes) {
        int largestPancakeSize = 0;
        int posOfLargestPancake = 0;
        for (int i = 0; i < pancakes.size(); i++) {
            if (pancakes.get(i) > largestPancakeSize) {
                largestPancakeSize = pancakes.get(i);
                posOfLargestPancake = i;
            }
        }
        return posOfLargestPancake;
    }

    protected int getLargestPancakesPos(int[] pancakes) {
        int largestPancakeSize = 0;
        int posOfLargestPancake = 0;
        for (int i = 0; i < pancakes.length; i++) {
            if (pancakes[i] > largestPancakeSize) {
                largestPancakeSize = pancakes[i];
                posOfLargestPancake = i;
            }
        }
        return posOfLargestPancake;
    }

    protected void flipPancakeToButton(List<Integer> pancakes, int posOfPancake) {
        boolean isPancakeAtButton = posOfPancake == 0;
        if (isPancakeAtButton) return;

        flipPancakesToTop(pancakes, posOfPancake);
        flipAllPancakes(pancakes);
    }

    public void flipPancakesToTop(List<Integer> pancakes, int posOfPancake) {
        boolean isPancakeAtTop = posOfPancake == pancakes.size() - 1;
        if (isPancakeAtTop) return;
        flipPancakes(pancakes, posOfPancake, pancakes.size());
    }

    public void flipAllPancakes(List<Integer> pancakes) {
        int posOfButtonPancake = 0;
        flipPancakesToTop(pancakes, posOfButtonPancake);
    }

    /**
     * start included, end excluded
     * @param pancakes
     * @param lower
     * @param upper
     */
    public void flipPancakes(List<Integer> pancakes, int lower, int upper) {
        if (pancakes.size() == 0 || lower == upper) return;
        if (pancakes.size() <= lower || upper < lower) throw new IllegalArgumentException();

        if (upper > pancakes.size()) upper = pancakes.size();
        int median = (upper - lower) / 2 + lower;
        for (int i = lower; i < median; i++) {
            int replaceIndex = upper - 1 - (i - lower);
            int temp = pancakes.get(i);
            pancakes.set(i, pancakes.get(replaceIndex));
            pancakes.set(replaceIndex, temp);
        }
        flipCounter++;
    }

    public int getFlipCounter() {
        return flipCounter;
    }

    protected void setFlipCounter(int num) {
        this.flipCounter = num;
    }

    public static void main(String ... args) {
        APileOfPancake a = new APileOfPancake();
        int[] pancakes = a.getShuffledPancakes(10);
        System.out.println("shuffled pancakes: " + Arrays.toString(pancakes));

        a.sortPancakes(pancakes);
        System.out.println("sorted pancakes: " + Arrays.toString(pancakes));

        System.out.println(String.format("flipped: %d times", a.getFlipCounter()));
    }
}
