package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenFruits {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0}, {0, 1, 1}, {0, 1, 2}};
        int answer = orangesRotting(grid);

        if (answer != -1) {
            System.out.println("TIME IT TOOK TO ROT ALL FRUITS: " + answer);
        } else {
            System.out.println("NOT POSSIBLE TO ROT ALL FRUITS!");
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        System.out.println("There are " + fresh + " fresh fruits and " + q.size() + " rotten fruits in the grid");

        while (fresh > 0 && !q.isEmpty()) {
            int length = q.size();
            System.out.println("There are currently " +length+ " rotten fruit(s) to iterate through");

            for (int i = 0; i < length; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                System.out.println("Currently checking rotten fruit at position[" +r+ "][" +c+"]");

                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row >= 0 && row < grid.length &&
                        col >= 0 && col < grid[0].length &&
                        grid[row][col] == 1
                    ) {
                        System.out.println("Turning fruit at position[" +row+ "][" +col+"] to a rotting fruit");
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }

            time++;
            System.out.println("Rotted all nearby fruits. Time is now " +time+ "\n");
        }

        System.out.println("Done! Returning answer...\n");
        return fresh == 0 ? time : -1;
    }
}
