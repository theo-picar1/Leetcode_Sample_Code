package priority_queue_heap;

import java.util.PriorityQueue;

// Problem should be used by another class to demonstrate

public class KthLargestElementInAStream {
    private PriorityQueue<Integer> minHeap;
    private int index;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.index = k;

        for(int num : nums) {
            this.minHeap.offer(num);

            // Remove the top element (the smallest element) so that the size of the heap is the same as what k is
            // If k is 3, the resulting heap will give us the top 3 largest nums
            if(this.minHeap.size() > this.index) this.minHeap.poll();
        }
    }

    public int add(int val) {
        this.minHeap.offer(val);

        if(this.minHeap.size() > this.index) this.minHeap.poll();

        // The element in front will always be our answer since we are only getting the top k largest nums
        // The num first in the heap happens to be out kth largest integer
        return minHeap.peek();
    }

    // Demo main method
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(k, nums);

        System.out.println("Adding 3 to the stream...");
        System.out.println("Min heap is now: " +kthLargest);
        System.out.println("3rd largest so far is: " +kthLargest.add(3)+ "\n");

        System.out.println("Adding 10 to the stream...");
        System.out.println("Min heap is now: " +kthLargest);
        System.out.println("3rd largest so far is: " +kthLargest.add(10)+ "\n");

        System.out.println("Adding 4 to the stream...");
        System.out.println("Min heap is now: " +kthLargest);
        System.out.println("3rd largest so far is: " +kthLargest.add(4)+ "\n");

        System.out.println("Adding 8 to the stream...");
        System.out.println("Min heap is now: " +kthLargest);
        System.out.println("3rd largest so far is: " +kthLargest.add(8)+ "\n");

        System.out.println("Adding 7 to the stream...");
        System.out.println("Min heap is now: " +kthLargest);
        System.out.println("3rd largest so far is: " +kthLargest.add(7)+ "\n");
    }
}
