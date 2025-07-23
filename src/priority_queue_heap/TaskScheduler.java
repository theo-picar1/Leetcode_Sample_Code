package priority_queue_heap;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'C'};
        int n = 3;

        int answer = leastInterval(tasks, n);

        System.out.println("ANSWER: " +answer);
    }

    public static int leastInterval(char[] tasks, int n) {
        System.out.println("Gathering frequencies...");

        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        System.out.println("Adding counts (above 0) to heap...");

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count) {
            if (cnt > 0) {
                maxHeap.add(cnt);
            }
        }

        System.out.println("Resulting heap: " +maxHeap);
        System.out.println("Calculating time to take...\n");

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            System.out.println("Incrementing time to " +time);

            if (maxHeap.isEmpty()) {
                System.out.println("The heap is empty, time will be equal to second element in queue, " +q.peek()[1]);
                time = q.peek()[1];
            }
            else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    System.out.println("Adding cnt (" +cnt+ ") and time + n (" +(time + n)+ ") to the queue as an int[]");
                    q.add(new int[]{cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                System.out.println("First second element in q is equal to time, adding queue's first value (" +q.peek()[0]+ ") to the heap");
                maxHeap.add(q.poll()[0]);
            }

            System.out.println("Max Heap so far: " +maxHeap);
            System.out.print("Queue so far: ");
            for(int[] qArr : q) {
                System.out.print(Arrays.toString(qArr));
            }
            System.out.println("\n");
        }

        return time;
    }
}
