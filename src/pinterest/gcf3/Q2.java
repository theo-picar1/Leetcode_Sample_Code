package pinterest.gcf3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2 {
    // Given a list of numbers, sort them by the sum of their digits

    public static void main(String[] args) {
        // Test case 1. Expected: [12, 111, 23, 7, 34]: PASSED
        List<Integer> arr1 = Arrays.asList(34, 12, 23, 7, 111);
        System.out.println("Answer: " + method(arr1));

        // Test case 2. Expected: [5, 14, 23, 32, 41]: PASSED
        List<Integer> arr2 = Arrays.asList(41, 32, 23, 14, 5);
        System.out.println("Answer: " + method(arr2));

        // Test case 3. Expected: [101, 110, 11, 2]: PASSED
        List<Integer> arr3 = Arrays.asList(101, 2, 11, 110);
        System.out.println("Answer: " + method(arr3));

        // Test case 4. Expected: [0, 10, 20, 3, 12]: PASSED
        List<Integer> arr4 = Arrays.asList(12, 0, 3, 10, 20);
        System.out.println("Answer: " + method(arr4));

        // Test case 5. Expected: [1, 100, 19, 28, 37]: PASSED
        List<Integer> arr5 = Arrays.asList(28, 1, 37, 19, 100);
        System.out.println("Answer: " + method(arr5));
    }

    public static List<Integer> method(List<Integer> list) {
        // Sort nums in ascending order by their digit's sum
        Collections.sort(list, (a, b) -> Integer.compare(sumOfDigits(a), sumOfDigits(b)));

        return list;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;

        // 12 will equal to 3 (1 + 2 = 3)
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
