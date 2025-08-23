package pinterest.gcf2;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    // Given a string in camelCase, split it into individual words.
    // ***** REVISE THIS QUESTION! *****

    public static void main(String[] args) {
        // Test case 1. Expected: ["camel", "Case"] ✅
        String str1 = "camelCase";

        // Test case 2. Expected: ["this", "Is", "Camel", "Case"] ✅
        String str2 = "thisIsCamelCase";

        // Test case 3. Expected: ["simple"] ✅
        String str3 = "simple";

        // Test case 4. Expected: [] ✅
        String str4 = "";

        // *** Test case 5. Expected: ["XML", "Parser", "Test"] ✅
        String str5 = "XMLParserTest";

        // Test case 6: Expected: ["JSON"] ✅
        String str6 = "JSON";

        // *** Test case 7: Expected: ["parse", "X", "Input"] ✅
        String str7 = "parseXInput";

        System.out.println("Answer: " + splitCamelCase(str5));
    }

    public static List<String> splitCamelCase(String str) {
        List<String> res = new ArrayList<>();

        int l = 0;
        for (int r = 1; r < str.length(); r++) {
            char curr = str.charAt(r);
            char prev = str.charAt(r - 1);

            // If current char is uppercase and previous is lowercase, it's a new word
            if (Character.isUpperCase(curr) && Character.isLowerCase(prev)) {
                res.add(str.substring(l, r));
                l = r;
            }
            // If the next element is lowercase, separate current uppercase from rest of prev uppercases
            else if (
                Character.isUpperCase(curr) && Character.isUpperCase(prev) &&
                r + 1 < str.length() && Character.isLowerCase(str.charAt(r + 1))
            ) {
                res.add(str.substring(l, r));
                l = r;
            }
        }

        // Add either the last word still remaining or the only word in the string
        if (l < str.length()) {
            res.add(str.substring(l));
        }

        return res;
    }
}
