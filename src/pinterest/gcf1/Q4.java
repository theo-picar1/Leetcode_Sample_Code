package pinterest.gcf1;

public class Q4 {
    // Given a string, return a version where vowels are replaced by *.
    private static final String VOWELS = "aeiouAEIOU";

    public static void main(String[] args) {
        // Test case 1. Expected: "H*ll*" ✅
        String str1 = "Hello";

        // Test case 2. Expected: "J*v* Pr*gr*mm*ng"  ✅
        String str2 = "Lala Staffordshire Bull Terrier";

        // Test case 3. Expected: "BCD" ✅
        String str3 = "BCD";

        // Test case 4. Expected: "****" ✅
        String str4 = "aeio";

        // Test case 5. Expected: "" ✅
        String str5 = "";

        System.out.println("Answer: " +method(str5));
    }

    public static String method(String s) {
        // String is immutable, so can't modify it in place
        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()) {
            // Same thing as contains
            if(VOWELS.indexOf(c) != -1) {
                res.append('*');
            }
            else {
                res.append(c);
            }
        }

        return res.toString();
    }
}