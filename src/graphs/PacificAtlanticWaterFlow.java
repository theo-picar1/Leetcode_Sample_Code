package graphs;

import java.util.*;

public class PacificAtlanticWaterFlow {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        List<List<Integer>> answer = pacificAtlantic(heights);

        System.out.println("\nALL CELLS THAT CAN REACH BOTH OCEANS: " +answer);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        Queue<int[]> pacific = new ArrayDeque<>();
        Queue<int[]> atlantic = new ArrayDeque<>();
        boolean[][] visitedPac = new boolean[ROWS][COLS];
        boolean[][] visitedAtl = new boolean[ROWS][COLS];

        System.out.println("Adding all vertical border cells...");
        // Get all vertical border cells
        for(int row = 0; row < ROWS; row++) {
            // Left
            pacific.offer(new int[]{row, 0});
            visitedPac[row][0] = true;

            // Right
            atlantic.offer(new int[]{row, COLS - 1});
            visitedAtl[row][COLS - 1] = true;
        }

        // Get all horizontal border cells
        System.out.println("Adding all horizontal border cells...\n");
        for(int col = 0; col < COLS; col++) {
            // Top
            pacific.offer(new int[]{0, col});
            visitedPac[0][col] = true;

            // Bottom
            atlantic.offer(new int[]{ROWS - 1, col});
            visitedAtl[ROWS - 1][col] = true;
        }

        // Cells that can reach pacific
        System.out.println("Finding more cells that can the pacific...");
        bfs(pacific, visitedPac, heights);

        System.out.println("Finding more cells that can the atlantic...\n");
        // Cells that can reach atlantic
        bfs(atlantic, visitedAtl, heights);

        // Answer are cells that are both marked true in both 'visited' arrays
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(visitedPac[i][j] && visitedAtl[i][j]) {
                    System.out.println("Cell at position [" +i+ "][" +j+ "] can reach both the atlantic and the pacific. Adding it to the list...");
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public static void bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];

            for(int[] direction : directions) {
                int i = row + direction[0];
                int j = col + direction[1];

                if(i >= 0 && i < ROWS &&
                   j >= 0 && j < COLS &&
                   heights[i][j] >= heights[row][col] && !visited[i][j]
                ) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
    }
}
