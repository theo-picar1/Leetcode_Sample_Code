package greedy;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "((**)";

        boolean valid = checkValidString(s);
        if(valid) {
            System.out.println("VALID PARENTHESIS STRING!");
        }
        else {
            System.out.println("INVALID PARENTHESIS STRING!");
        }
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> parentheses = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(curr == '(') {
                System.out.println("Pushing index " +i+ " to the parentheses '(' stack...");
                parentheses.push(i);
            }
            else if(curr == '*') {
                System.out.println("Pushing index " +i+ " to the star '*' stack...");
                stars.push(i);
            }
            else {
                if(parentheses.isEmpty() && stars.isEmpty()) {
                    System.out.println("Encountered ')' but both stacks are empty. Returning false...\n");
                    return false;
                }
                else if(!parentheses.isEmpty()) {
                    System.out.println("Encountered ')'. Popping a '('...");
                    parentheses.pop();
                }
                else {
                    System.out.println("Encountered ')' but parentheses is empty. Popping a '*'...");
                    stars.pop();
                }
            }
        }

        System.out.println("\nParentheses stack so far: " +parentheses);
        System.out.println("Stars stack so far: " +stars);
        while(!parentheses.isEmpty() && !stars.isEmpty()) {
            if (parentheses.peek() > stars.peek()) {
                System.out.println("'(' index (" + parentheses.peek() + ") is after '*' index (" + stars.peek() + "). Returning false...\n");
                return false;
            }

            System.out.println("Valid so far. Popping both '(' and '*' from the stacks...");
            parentheses.pop();
            stars.pop();
        }

        System.out.println("\nFinal parentheses stack: " +parentheses);
        System.out.println("Final stars stack: " +stars);
        if(parentheses.isEmpty()) {
            System.out.println("String '" +s+ "' is valid!\n");
            return true;
        }
        else {
            System.out.println("There are still '(' parentheses left over in the stack. Returning false...\n");
            return false;
        }
    }
}
