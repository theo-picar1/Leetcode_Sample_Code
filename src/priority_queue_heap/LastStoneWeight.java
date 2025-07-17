package priority_queue_heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 3, 6, 2, 4};

        int weight = lastStoneWeight(stones);

        System.out.println("Weight: " +weight);
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int stone : stones) {
            maxHeap.offer(-stone); // Negative it, so initially smaller elements are actually the larger ones
        }

        while(maxHeap.size() > 1) {
            // 2 largest so far
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            System.out.println("Smashing stones with weights " +stone2+ " and " +stone1);
            int smashed = stone2 - stone1; // If they were positive, it would be stone1 - stone2

            // Revert smashed stone weight back to negative
            if(smashed > 0) {
                System.out.println("Created stone with weight " +(smashed *= -1));
                maxHeap.offer(-smashed);
            }
            else {
                System.out.println("Complete destroyed stone");
            }

            System.out.println("Stones left: " +maxHeap+ "\n");
        }

        // If there is one stone left, return that. Otherwise return 0
        return maxHeap.size() == 1 ? Math.abs(maxHeap.peek()) : 0;
    }
}
