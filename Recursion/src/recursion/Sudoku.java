package recursion;

public class Sudoku {

    private int[][] board;

    public Sudoku(int[][] board) {
        this.board = new int[9][9];
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 9; columnIndex++) {
                this.board[rowIndex][columnIndex] = board[rowIndex][columnIndex];
            }
        }
    }

    private int[] getFirst0() {
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 9; columnIndex++) {
                if (board[rowIndex][columnIndex] == 0) {
                    return new int[]{rowIndex, columnIndex};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean canPlaceNumberAtRow(int number, int rowIndex) {
        for (int currentNumber : board[rowIndex]) {
            if (number == currentNumber) {
                return false;
            }
        }
        return true;
    }

    private boolean canPlaceNumberAtColumn(int number, int columnIndex) {
        for (int[] row : board) {
            if (row[columnIndex] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean canPlaceNumberIn3by3(int number, int rowIndex, int columnIndex) {
        int firstRow = rowIndex / 3 * 3;
        int firstColumn = columnIndex / 3 * 3;

        for (int rowIndexToCheck = firstRow; rowIndexToCheck < firstRow + 3; rowIndexToCheck++) {
            for (int columnIndexToCheck = firstColumn; columnIndexToCheck < firstColumn + 3; columnIndexToCheck++) {
                if (board[rowIndexToCheck][columnIndexToCheck] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean canPlaceNumber(int number, int rowIndex, int columnIndex) {
        return canPlaceNumberAtRow(number, rowIndex)
                && canPlaceNumberAtColumn(number, columnIndex)
                && canPlaceNumberIn3by3(number, rowIndex, columnIndex);
    }

    private int count0s() {
        int zeros = 0;
        for (int[] row : board) {
            for (int number : row) {
                if (number == 0) {
                    zeros++;
                }
            }
        }

        return zeros;
    }

    public void solve() {
        if (!isSolved()) {
            int[] first0 = getFirst0();
            int rowIndex = first0[0];
            int columnIndex = first0[1];

            for (int number = 1; number <= 9; number++) {
                if (canPlaceNumber(number, rowIndex, columnIndex)) {
                    board[rowIndex][columnIndex] = number;
                    solve();
                    // if it returns from the recursive call and isn't solved, undo
                    if (!isSolved()) {
                        board[rowIndex][columnIndex] = 0;
                    }
                }
            }
        } else {
            System.out.println(toString());
            System.out.println("");
        }

    }

    private String getRowString(int rowIndex) {
        return String.format("|%d|%d|%d|%d|%d|%d|%d|%d|%d|\n",
                this.board[rowIndex][0],
                this.board[rowIndex][1],
                this.board[rowIndex][2],
                this.board[rowIndex][3],
                this.board[rowIndex][4],
                this.board[rowIndex][5],
                this.board[rowIndex][6],
                this.board[rowIndex][7],
                this.board[rowIndex][8]);
    }

    private boolean isSolved() {
        for (int[] row : board) {
            for (int number : row) {
                if (number == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            builder.append(getRowString(rowIndex));
        }
        return builder.toString();
    }
}
