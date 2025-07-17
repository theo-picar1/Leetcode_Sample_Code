package priority_queue_heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;

        int largest = findKthLargest(nums, k);
        System.out.println("LARGEST NUM: " +largest);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            System.out.println("Adding " + num + " to the heap...");
            minHeap.offer(num);

            if(minHeap.size() > k) {
                System.out.println("Size overflow, removing front element: " +minHeap.peek());
                minHeap.poll();
            }

            System.out.println("Min Heap so far: " +minHeap+ "\n");
        }

        return minHeap.peek();
    }
}
