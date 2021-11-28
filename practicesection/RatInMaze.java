package practicesection;

import java.util.Arrays;

public class RatInMaze {
    public static void main(String[] args) {
        boolean maze[][] = { { true, false, false, false }, { true, true, false, true }, { false, true, false, false },
                { true, true, true, true } };

        boolean path[][] = new boolean[maze.length][maze[0].length];
        boolean result = solveMaze(maze, 0, 0, path);

        printArray(path);
    }
    

    public static void printArray(boolean arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    
    static boolean solveMaze(boolean maze[][], int row, int col, boolean[][] path) {
        if (row == maze.length - 1 && col == maze[0].length) {
            return true;
        }

        // if a path has been covered earlier we should mark it false, we dont want to keep
        // rotating in circles
        if (row >= 0 && row < maze.length && col >= 0 
                && col < maze[0].length && maze[row][col] == true && path[row][col] == false
            ) {
                path[row][col] = true;
                if (solveMaze(maze, row + 1, col, path)) {
                    return true;
                }

                if (solveMaze(maze, row, col + 1, path)) {
                    return true;
                }

                path[row][col] = true;
        }
        

        return false;
    }
}
