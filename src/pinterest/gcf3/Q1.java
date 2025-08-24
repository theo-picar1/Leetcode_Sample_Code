package pinterest.gcf3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1 {
    // Implement a comparator that sorts words first by vowel count, then alphabetically.

    public static void main(String[] args) {
        // Test case 1. Expected: [dog, apple, bee, eat] PASSED
        List<String> arr1 = Arrays.asList("apple", "dog", "eat", "bee");
        System.out.println("Answer: " + method(arr1));

        // Test case 2. Expected: [bat, cat, alpha, zoom] PASSED
        List<String> arr2 = Arrays.asList("zoom", "cat", "bat", "alpha");
        System.out.println("Answer: " + method(arr2));

        // Test case 3. Expected: [x, y, z] PASSED
        List<String> arr3 = Arrays.asList("x", "y", "z");
        System.out.println("Answer: " + method(arr3));

        // Test case 4. Expected: [i, o, u, ee, aaa] PASSED
        List<String> arr4 = Arrays.asList("aaa", "ee", "i", "o", "u");
        System.out.println("Answer: " + method(arr4));

        // Test case 5. Expected: [quiz, quiet, queue] PASSED
        List<String> arr5 = Arrays.asList("queue", "quiet", "quiz");
        System.out.println("Answer: " + method(arr5));
    }

    public static List<String> method(List<String> list) {
        Collections.sort(list, (a, b) -> {
            int compare = Integer.compare(countVowels(a), countVowels(b));
            // Sort by vowel count
            if(compare != 0) {
                return compare;
            }

            // Otherwise, sort alphabetically
            return a.compareTo(b);
        });

        return list;
    }

    public static int countVowels(String s) {
        final String vowels = "aeiouAEIOU";

        int count = 0;
        for(char c : s.toCharArray()) {
            if(vowels.indexOf(c) != -1) {
                count++;
            }
        }

        return count;
    }
}
