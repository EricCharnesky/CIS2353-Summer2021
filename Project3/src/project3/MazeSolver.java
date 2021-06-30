package project3;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeSolver {

    public static char WALL = 'W';
    public static char OPEN = ' ';
    public static char START = 'S';
    public static char END = 'E';

    private ArrayList<ArrayList<Character>> maze;
    private int currentRowIndex;
    private int currentColumnIndex;
    private int currentNumberOfMoves;
    private int shortestNumberOfMoves;

    public MazeSolver(ArrayList<ArrayList<Character>> maze) {
        // should copy?
        this.maze = maze;
        int[] startLocation = findStart();
        currentRowIndex = startLocation[0];
        currentColumnIndex = startLocation[1];
        currentNumberOfMoves = 0;
        shortestNumberOfMoves = Integer.MAX_VALUE;
        solve();
    }

    public int getShortestNumberOfMoves() {
        return shortestNumberOfMoves;
    }

    public boolean isSolveable() {
        return shortestNumberOfMoves != Integer.MAX_VALUE;
    }

    public void solve() {
        
        if ( currentNumberOfMoves > shortestNumberOfMoves){
            return;
        }
        
        if (areWeAtTheEnd()) {
            if (currentNumberOfMoves < shortestNumberOfMoves) {
                shortestNumberOfMoves = currentNumberOfMoves;
            }
            return;
        }

        currentNumberOfMoves++;
        setCharacterAtCurrentlyLocation('.');

        if (canGoUp()) {
            currentRowIndex--;
            solve();
            currentRowIndex++;
        }
        if (canGoDown()) {
            currentRowIndex++;
            solve();
            currentRowIndex--;
        }
        if (canGoLeft()) {
            currentColumnIndex--;
            solve();
            currentColumnIndex++;
        }
        if (canGoRight()) {
            currentColumnIndex++;
            solve();
            currentColumnIndex--;
        }

        currentNumberOfMoves--;
        setCharacterAtCurrentlyLocation(' ');

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (ArrayList<Character> row : maze) {
            builder.append(Arrays.toString(row.toArray()));
            builder.append("\n");
        }
        return builder.toString();

    }

    private boolean canMoveTo(int rowIndex, int columnIndex) {
        return rowIndex >= 0 && rowIndex < maze.size()
                && columnIndex >= 0 && columnIndex < maze.get(rowIndex).size()
                && (maze.get(rowIndex).get(columnIndex) == OPEN
                || maze.get(rowIndex).get(columnIndex) == END);
    }

    private boolean canGoUp() {
        return canMoveTo(currentRowIndex - 1, currentColumnIndex);
    }

    private boolean canGoDown() {
        return canMoveTo(currentRowIndex + 1, currentColumnIndex);
    }

    private boolean canGoLeft() {
        return canMoveTo(currentRowIndex, currentColumnIndex - 1);
    }

    private boolean canGoRight() {
        return canMoveTo(currentRowIndex, currentColumnIndex + 1);
    }

    private boolean areWeAtTheEnd() {
        return maze.get(currentRowIndex).get(currentColumnIndex) == END;
    }

    private void setCharacterAtCurrentlyLocation(char character) {
        if (maze.get(currentRowIndex).get(currentColumnIndex) != START) {
            maze.get(currentRowIndex).set(currentColumnIndex, character);
        }
    }

    private int[] findStart() {
        for (int rowIndex = 0; rowIndex < maze.size(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < maze.get(rowIndex).size(); columnIndex++) {
                if (maze.get(rowIndex).get(columnIndex) == START) {
                    return new int[]{rowIndex, columnIndex};
                }
            }
        }

        return new int[]{0, 0};
    }

}
