package pinterest.gcf1;

public class Q5 {
    // Given a string, return the count of words (separated by spaces).

    public static void main(String[] args) {
        // Test case 1. Expected: 2 ✅
        String str1 = "Hello World";

        // Test case 2. Expected: 4 ✅
        String str2 = "     Java is really fun  ";

        // Test case 3. Expected: 1 ✅
        String str3 = "Hello";

        // Test case 4. Expected: 0 ✅
        String str4 = "";

        // Test case 5. Expected: 3 ✅
        String str5 = "one   two   three";

        System.out.println("Answer: " +method(str5));
    }

    public static int method(String s) {
        if(s.isEmpty()) return 0;

        String newS = s.trim(); // Make sure there no leading or trailing spaces

        int res = 1; // There will always be 1 word. So start at 1
        for(int i = 1; i < newS.length(); i++) {
            if(newS.charAt(i) == ' ' && newS.charAt(i - 1) != ' ') {
                res++;
            }
        }

        return res;
    }
}
