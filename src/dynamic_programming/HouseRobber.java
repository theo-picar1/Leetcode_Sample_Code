package dynamic_programming;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {402,5201,542,110, 1011};

        int answer = rob(nums);
        System.out.println("Max amount we can rob is €" +answer);
    }

    public static int rob(int[] nums) {
        int maxRobTwoHousesAgo = 0, maxRobAHouseAgo = 0;

        int index = 1;
        for(int num : nums) {
            System.out.println("On house " +index+ " with a value of €" +num);
            index++;

            System.out.println("Deciding best total value between €" +num+ " + €" +maxRobTwoHousesAgo+ " and €" +maxRobAHouseAgo);
            int currTotal = Math.max(num + maxRobTwoHousesAgo, maxRobAHouseAgo);
            System.out.println("Best total value we have is now €" +currTotal);

            System.out.println("maxRobTwoHousesAgo is now €" +maxRobAHouseAgo+ " and maxRobAHouseAgo is now €" +currTotal +"\n");

            maxRobTwoHousesAgo = maxRobAHouseAgo;
            maxRobAHouseAgo = currTotal;
        }

        return maxRobAHouseAgo;
    }
}
