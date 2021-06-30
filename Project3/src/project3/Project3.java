package project3;

import java.util.ArrayList;
import java.util.Arrays;

public class Project3 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> maze = new ArrayList<ArrayList<Character>>();

        Character[] row1 = new Character[]{' ', ' ', ' ', ' ', ' '};
        Character[] row2 = new Character[]{'X', ' ', 'X', 'S', 'X'};
        Character[] row3 = new Character[]{'X', ' ', 'X', ' ', ' '};
        Character[] row4 = new Character[]{' ', ' ', 'X', ' ', ' '};
        Character[] row5 = new Character[]{' ', ' ', ' ', ' ', 'E'};

        maze.add(new ArrayList<>(Arrays.asList(row1)));
        maze.add(new ArrayList<>(Arrays.asList(row2)));
        maze.add(new ArrayList<>(Arrays.asList(row3)));
        maze.add(new ArrayList<>(Arrays.asList(row4)));
        maze.add(new ArrayList<>(Arrays.asList(row5)));

        MazeSolver mazeSolver = new MazeSolver(maze);
        if (mazeSolver.isSolveable()) {
            System.out.println("Shortest path: " + mazeSolver.getShortestNumberOfMoves());
            System.out.println(mazeSolver);
        }

        for (int mazeNumber = 0; mazeNumber < 100; mazeNumber++) {
            mazeSolver = new MazeSolver(MazeGenerator.generateMaze());
            if (mazeSolver.isSolveable()) {
                System.out.println("Shortest path: " + mazeSolver.getShortestNumberOfMoves());
                System.out.println(mazeSolver);
            }
        }
    }

}
