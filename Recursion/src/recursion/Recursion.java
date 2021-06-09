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

        sudoku.solve();

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
