package project3;

import java.util.ArrayList;
import java.util.Random;

public class MazeGenerator {

    static Random random = new Random();

    public static ArrayList<ArrayList<Character>> generateMaze(){
        return generateMaze(10, 10);
    }
    
    public static ArrayList<ArrayList<Character>> generateMaze(int maxRows, int maxColumns) {
        int rows = random.nextInt(maxRows - 5) + 5;
        int columns = random.nextInt(maxColumns - 5) + 5;

        ArrayList<ArrayList<Character>> maze = new ArrayList<ArrayList<Character>>();

        for (int row = 0; row < rows; row++) {
            maze.add(new ArrayList<Character>());
            for (int column = 0; column < columns; column++) {
                if (random.nextInt(4) == 0) {
                    maze.get(row).add(MazeSolver.WALL);
                } else {
                    maze.get(row).add(MazeSolver.OPEN);
                }
            }
        }

        int endRowIndex = random.nextInt(rows);
        int endColumnIndex = random.nextInt(columns);

        maze.get(endRowIndex).set(endColumnIndex, MazeSolver.END);

        int startRowIndex = random.nextInt(rows);
        int startColumnIndex = random.nextInt(columns);

        maze.get(startRowIndex).set(startColumnIndex, MazeSolver.START);

        return maze;

    }

}
