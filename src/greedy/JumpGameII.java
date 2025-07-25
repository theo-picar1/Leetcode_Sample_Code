package greedy;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,4,1,1,1,1};

        int jumps = jump(nums);

        System.out.println("Minimum jumps needed is " +jumps+ " jumps.");
    }

    public static int jump(int[] nums) {
        int res = 0, l = 0, r = 0;

        while(r < nums.length - 1) {
            int farthestIndexReached = 0;

            for(int i = l; i <= r; i++) {
                System.out.println("Checking jump distance for index " +i+ " -> " +nums[i]+ "...");
                farthestIndexReached = Math.max(farthestIndexReached, i + nums[i]);
                System.out.println("Farthest distance we can jump so far is " +farthestIndexReached);
            }

            l = r + 1;
            r = farthestIndexReached;
            res++;

            System.out.println("Starting at index " +l+ " up to our furthest possible index " +r+ "\n");
        }

        return res;
    }
}
