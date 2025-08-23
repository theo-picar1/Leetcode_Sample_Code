package pinterest.gcf1;

public class Q2 {
    // Given a string, return a new string where
    // each character is followed by its ASCII value.

    public static void main(String[] args) {
        // Test case 1. Expected: "A65B66 ✅"
        String str1 = "AB";

        // Test case 2. Expected: "a97Z90 ✅"
        String str2 = "aZ";

        // Test case 3. Expected: "H72i105 32 ✅"
        String str3 = "Hi ";

        // Test case 4. Expected: "452250 ✅"
        String str4 = "42";

        // Test case 5. Expected: "!33?63 ✅"
        String str5 = "!?";

        System.out.println("Answer: " +method(str5));
    }

    public static String method(String str) {
        StringBuilder res = new StringBuilder();

        for(char c : str.toCharArray()) {
            res.append(c); // Append the char as itself

            int ascii = c;
            res.append(ascii); // Then append the ascii equivalent
        }

        return res.toString();
    }
}
