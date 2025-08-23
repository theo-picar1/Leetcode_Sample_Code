package pinterest.gcf2;

import java.util.HashSet;
import java.util.Set;

public class Q2 {
    // Given two strings, return the number of characters that appear in both.

    public static void main(String[] args) {
        // Test case 1. Expected: 2 ✅
        String str1a = "abc";
        String str1b = "bcd";
        System.out.println("Answer: " + method(str1a, str1b));

        // Test case 2. Expected: 0 ✅
        String str2a = "abc";
        String str2b = "xyz";
        System.out.println("Answer: " + method(str2a, str2b));

        // Test case 3. Expected: 3 ✅
        String str3a = "abc";
        String str3b = "cab";
        System.out.println("Answer: " + method(str3a, str3b));

        // Test case 4. Expected: 0 ✅
        String str4a = "";
        String str4b = "abc";
        System.out.println("Answer: " + method(str4a, str4b));

        // Test case 5. Expected: 3 ✅
        String str5a = "aabbcc";
        String str5b = "abc";
        System.out.println("Answer: " + method(str5a, str5b));

        // Test case 6. Expected: 1 ✅
        String str6a = "AbC";
        String str6b = "abc";
        System.out.println("Answer: " + method(str6a, str6b));

        // Test case 7. Expected: 2 ✅
        String str7a = "123!@#";
        String str7b = "3!$";
        System.out.println("Answer: " + method(str7a, str7b));
    }

    public static int method(String str1, String str2) {
        Set<Character> set1 = new HashSet<>(), set2 = new HashSet<>();

        // Put all chars in their corresponding sets to prevent dupes
        for(char c : str1.toCharArray()) {
            set1.add(c);
        }
        for(char c : str2.toCharArray()) {
            set2.add(c);
        }

        // Then compare chars in each
        int res = 0;
        for(char c : set1) {
            if(set2.contains(c)) {
                res++;
            }
        }

        return res;
    }
}
