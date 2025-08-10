package intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}, {3, 5},{4,6}};

        int answer = eraseOverlapIntervals(intervals);
        System.out.println("Amount of intervals to remove is " + answer);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            System.out.println("Current interval is " +Arrays.toString(intervals[i]));

            if (start >= prevEnd) {
                System.out.println("Valid! Current start position of interval is greater than previous end interval (" +prevEnd+ "). Updating prev end and moving on...\n");
                prevEnd = end;
            }
            else {
                res++;
                System.out.println("Invalid! Current start position of interval is less than previous end interval (" +prevEnd+ "). Incrementing res to " +res+ "\n");
                prevEnd = Math.min(end, prevEnd);
            }
        }
        return res;
    }
}
