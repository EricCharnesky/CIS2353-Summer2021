package recursion;

public class Recursion {

    public static void main(String[] args) {
        int[][] board = new int[][]{
            {0, 1, 0, 0, 0, 0, 9, 0, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 4},
            {7, 0, 5, 0, 8, 3, 2, 0, 0},
            {2, 0, 0, 0, 0, 9, 0, 4, 0},
            {9, 0, 7, 4, 0, 2, 8, 0, 3},
            {0, 8, 0, 7, 0, 0, 0, 0, 9},
            {0, 0, 6, 1, 2, 0, 3, 0, 8},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {3, 0, 8, 0, 0, 0, 0, 7, 0}
        };

        Sudoku sudoku = new Sudoku(board);

        //sudoku.solve();
        try {
            Rectangle rectangle = new Rectangle(-1, 5);
            System.out.println("area is: " + rectangle.getArea());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        for (int nth = 0; nth < 46; nth++) {
            System.out.println(nth + ": " + fib(nth));
        }

    }

    // less efficient than the iterative solution
    private static int fibHelper(int nth, int currentNth, int previous, int current) {
        if (nth == currentNth) {
            return previous + current;
        }
        return fibHelper(nth, currentNth + 1, current, previous + current);
    }

    public static int fib(int nth) {
        if (nth == 0) {
            return 0;
        }
        if (nth == 1) {
            return 1;
        }
        return fibHelper(nth, 2, 0, 1);
    }

    public static int interativeFib(int nth) {
        if (nth == 0) {
            return 0;
        }
        if (nth == 1) {
            return 1;
        }
        int previous = 0;
        int current = 1;
        int currentNth = 2;
        while (currentNth < nth) {
            int next = previous + current;
            previous = current;
            current = next;
            currentNth++;
        }
        return previous + current;
    }

    public static int badfib(int nth) {
        if (nth == 0) {
            return 0;
        }
        if (nth == 1) {
            return 1;
        }
        return badfib(nth - 1) + badfib(nth - 2);
    }

// essentially a loop
    public static void countDown(int number) {
        if (number <= 0) {
            System.out.println("Blast off!");
        } else {
            System.out.println(number);
            countDown(--number);
        }
    }

    public static void countDownLoop(int number) {
        while (number > 0) {
            System.out.println(number);
            number--;
        }
        System.out.println("Blast off!");
    }

}
