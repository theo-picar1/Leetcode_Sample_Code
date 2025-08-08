package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3},{4,6}};
        int[] newInterval = {2, 5};

        int[][] answer = insert(intervals, newInterval);
        System.out.println("FINAL INTERVALS ARRAY " + Arrays.deepToString(answer));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]) {
            System.out.println("Interval " + Arrays.toString(intervals[i]) + " is lower than " + Arrays.toString(newInterval) + ", adding it to res...");
            res.add(intervals[i]);
        }

        System.out.println();

        while(i < n && newInterval[1] >= intervals[i][0]) {
            System.out.println("Interval " + Arrays.toString(intervals[i]) + " overlaps with " + Arrays.toString(newInterval) + ", updating newInterval...");
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            System.out.println("Updated newInterval: " + Arrays.toString(newInterval));
            i++;
        }
        System.out.println("Adding " +Arrays.toString(newInterval)+ " to res...\n");
        res.add(newInterval);

        while(i < n) {
            System.out.println("Adding remaining " +Arrays.toString(intervals[i])+ " to res...");
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
