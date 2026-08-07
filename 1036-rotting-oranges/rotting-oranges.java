import java.util.*;

class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        // Count fresh oranges and add rotten oranges to the queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If there are no fresh oranges
        if (fresh == 0) {
            return 0;
        }

        // Directions: Up, Down, Left, Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Multi-Source BFS
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pair curr = q.remove();

                for (int d = 0; d < 4; d++) {

                    int newRow = curr.row + dr[d];
                    int newCol = curr.col + dc[d];

                    if (newRow >= 0 &&
                        newRow < grid.length &&
                        newCol >= 0 &&
                        newCol < grid[0].length &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        q.add(new Pair(newRow, newCol));
                    }
                }
            }

            minutes++;
        }

        if (fresh == 0) {
            return minutes;
        }

        return -1;
    }
}