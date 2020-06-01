package per.mingda.bop.chap1.a_pile_of_pies;

import java.util.List;

public class PieFlipper {

    int flipCounter = 0;

    protected void sortPies(List<Integer> pies) {
        if (pies.size() <= 1) return;

        int posOfLargestPies = getLargestPiesPos(pies);
        flipPieToButton(pies, posOfLargestPies);

        List<Integer> piesExcludeBottom = pies.subList(1, pies.size());
        sortPies(piesExcludeBottom);
    }

    protected int getLargestPiesPos(List<Integer> pies) {
        int largestPieSize = 0;
        int posOfLargestPie = 0;
        for (int i = 0; i < pies.size(); i++) {
            if (pies.get(i) > largestPieSize) {
                largestPieSize = pies.get(i);
                posOfLargestPie = i;
            }
        }
        return posOfLargestPie;
    }

    protected void flipPieToButton(List<Integer> pies, int posOfPie) {
        boolean isPieAtButton = posOfPie == 0;
        if (isPieAtButton) return;

        flipPiesToTop(pies, posOfPie);
        flipAllPies(pies);
    }

    public void flipPiesToTop(List<Integer> pies, int posOfPie) {
        boolean isPieAtTop = posOfPie == pies.size() - 1;
        if (isPieAtTop) return;
        flipPies(pies, posOfPie, pies.size());
    }

    public void flipAllPies(List<Integer> pies) {
        int posOfButtonPie = 0;
        flipPiesToTop(pies, posOfButtonPie);
    }

    /**
     * start included, end excluded
     * @param pies
     * @param lower
     * @param upper
     */
    public void flipPies(List<Integer> pies, int lower, int upper) {
        if (pies.size() == 0 || lower == upper) return;
        if (pies.size() <= lower || upper < lower) throw new IllegalArgumentException();

        if (upper > pies.size()) upper = pies.size();
        int median = (upper - lower) / 2 + lower;
        for (int i = lower; i < median; i++) {
            int replaceIndex = upper - 1 - (i - lower);
            int temp = pies.get(i);
            pies.set(i, pies.get(replaceIndex));
            pies.set(replaceIndex, temp);
        }
        this.flipCounter++;
    }

    public int getFlipCounter() {
        return this.flipCounter;
    }

    public void setFlipCounter(int num) {
        this.flipCounter = num;
    }
}
