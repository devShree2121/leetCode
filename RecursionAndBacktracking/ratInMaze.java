package leetCode.RecursionAndBacktracking;



/**
 You are given a starting position for a rat, which is stuck in a maze at an initial point (0,0). The maze can be thought of as a 2-dimensional plane. It is represented as a square matrix of order 
N×N, where cells with value 0 represent blocked locations and cells with value 1 are open paths that the rat can use to reach its destination. The rat's destination is at 

(N−1,N−1). Your task is to count
 all possible paths that the rat can take to reach from the source to the destination in the maze. The rat can move in the following directions: 'U' (up) to 

(x,y−1), 'D' (down) to (x,y+1), 'L' (left) to  (x−1,y), and 'R' (right) to (x+1,y)

 */
public class ratInMaze {

    private static int findTotalPaths(int[][] maze, int n, int row, int col) {
        // Base case: If the rat has reached the destination
        if (row == n - 1 && col == n - 1) {
            return 1;
        }

        // Check if the current cell is out of bounds or blocked
        if (row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0) {
            return 0;
        }

        // Mark the current cell as visited
        maze[row][col] = 0;

        // Initialize a variable to keep track of the number of paths
        int totalPaths = 0;

        // Explore all possible directions: up, down, left, right

        // Move Up
        if (row > 0 && maze[row - 1][col] == 1) {
            totalPaths += findTotalPaths(maze, n, row - 1, col);
        }

        // Move Down
        if (row < n - 1 && maze[row + 1][col] == 1) {
            totalPaths += findTotalPaths(maze, n, row + 1, col);
        }

        // Move Left
        if (col > 0 && maze[row][col - 1] == 1) {
            totalPaths += findTotalPaths(maze, n, row, col - 1);
        }

        // Move Right
        if (col < n - 1 && maze[row][col + 1] == 1) {
            totalPaths += findTotalPaths(maze, n, row, col + 1);
        }

        // Unmark the current cell to allow for other paths to explore it
        maze[row][col] = 1;

        return totalPaths;
    }

    public static void main(String[] args) {
        int n = 4; // number of rows and columns
        int row = 0, col = 0; // initial starting point

        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };

        int totalPaths = findTotalPaths(maze, n, row, col);
        System.out.println(totalPaths); // Output the total number of paths
    }
}
