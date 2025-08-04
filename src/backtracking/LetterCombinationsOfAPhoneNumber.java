package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "34";

        List<String> answer = letterCombinations(digits);

        System.out.println("All possible letter combinations are: " +answer);
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        res.add("");

        String[] letters = {
                "", "", "abc", "def", "ghi", "jkl",
                "mno", "qprs", "tuv", "wxyz"
        };

        for(char digit : digits.toCharArray()) {
            System.out.println("Currently on digit '" + digit+ "'");
            List<String> temp = new ArrayList<>();

            for(String curr : res) {

                System.out.println("Currently on string " +curr+ " from the res list");
                for(char c : letters[digit - '0'].toCharArray()) {
                    System.out.println("Appending '" +curr+ "' and '" +c+ "', and adding it to temp");
                    temp.add(curr + c); // This is just appending the char to the current string in res. Not ASCII
                    System.out.println("Temp so far is " +temp);
                }
            }

            res = temp;
            System.out.println("Res so far is " +res+ "\n");
        }

        return res;
    }
}
