package per.mingda.bop.chap1;

public class ChineseChess {
    // 0 1 2
    // 3 4 5
    // 6 7 8

    short i = 0;

    private void printAllLegitPosition() {
        for (; i < 81; i++) {
            // int a = i / 9;
            // int b = i % 9;
            if (i / 9 % 3 != i % 9 % 3) {
                System.out.println(String.format("A: %d, B: %d.", i/9, i%9));
            }
        }
    }

    public static void main(String ... args) {
        ChineseChess cc = new ChineseChess();
        cc.printAllLegitPosition();
    }
}