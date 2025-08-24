package pinterest.gcf3;

import java.util.Arrays;

public class Q3 {
    // Given two strings, merge them but keep characters in lexicographically smaller order.

    public static void main(String[] args) {
        // Test case 1. Expected: "aabbcc": PASSED
        String s1_1 = "abc";
        String s1_2 = "abc";
        System.out.println("Answer: " + method(s1_1, s1_2));

        // Test case 2. Expected: "aaabbb": PASSED
        String s2_1 = "aaa";
        String s2_2 = "bbb";
        System.out.println("Answer: " + method(s2_1, s2_2));

        // Test case 3. Expected: "abcdef": PASSED
        String s3_1 = "ace";
        String s3_2 = "bdf";
        System.out.println("Answer: " + method(s3_1, s3_2));

        // Test case 4. Expected: "abbccdde": PASSED
        String s4_1 = "bcd";
        String s4_2 = "abcde";
        System.out.println("Answer: " + method(s4_1, s4_2));

        // Test case 5. Expected: "a": PASSED
        String s5_1 = "";
        String s5_2 = "a";
        System.out.println("Answer: " + method(s5_1, s5_2));

        // Test case 6. Expected: "": PASSED
        String s6_1 = "";
        String s6_2 = "";
        System.out.println("Answer: " + method(s6_1, s6_2));

        // Test case 7. Expected: "acegik": PASSED
        String s7_1 = "cik";
        String s7_2 = "aeg";
        System.out.println("Answer: " + method(s7_1, s7_2));
    }
    public static String method(String s1, String s2) {
        StringBuilder res = new StringBuilder();

        // Sort both chars by turning them into arrays
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Convert both arrays back into strings
        String str1 = new String(arr1);
        String str2 = new String(arr2);

        // Compare curr chars of both stings with two pointers
        int l = 0, r = 0;
        while(l < str1.length() && r < str2.length()) {
            if(str1.charAt(l) <= str2.charAt(r)) {
                res.append(str1.charAt(l++));
            }
            else {
                res.append(str2.charAt(r++));
            }
        }

        // Then add any leftover elements from either string if there are any
        if(l < str1.length()) {
            res.append(str1.substring(l));
        }
        else if(r < str2.length()) {
            res.append(str2.substring(r));
        }

        return res.toString();
    }
}
