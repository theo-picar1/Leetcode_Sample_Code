package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String word = "aab";

        List<List<String>> answer = partition(word);

        System.out.println("ALL POSSIBLE PALINDROMES ARE: " +answer);
    }

    public static List<List<String>> partition(String s) {
        if(s.isEmpty()) return new ArrayList<>();

        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        dfs(0, s, part, res);

        return res;
    }

    private static void dfs(int i, String s, List<String> part, List<List<String>> res) {
        if(i >= s.length()) {
            res.add(new ArrayList<>(part));
            System.out.println("Index i is over s.length(), 3. Adding " +part+ " to res... Res is now " +res+ "\n");
            return;
        }

        System.out.println("Starting at index " +i);
        for(int j = i; j < s.length(); j++) {
            System.out.println("Currently on j index " +j);
            System.out.println("Checking if substring '" +s.substring(i, j+1)+ "' is a palindrome...");
            if(isPalindrome(s, i, j)) {
                part.add(s.substring(i, j+1));
                System.out.println("It is! Adding '" +s.substring(i, j+1)+ "' to part... Part is now " +part);

                System.out.println("Incrementing j and backtracking...\n");
                dfs(j + 1, s, part, res);

                System.out.println("Removing last element, " +part.getLast()+ ", in part...");
                part.removeLast();
                System.out.println("Part now consists of the following, " +part+ "\n");
            }
            else System.out.println("It is not! Moving on...\n");
        }
    }

    public static boolean isPalindrome(String word, int l, int r) {
        while(l <= r) {
            if(word.charAt(l) != word.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
