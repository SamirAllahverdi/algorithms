package leetcode.recentImpls;

import java.util.*;

public class ValidParentheses {

    /**
     * https://leetcode.com/problems/valid-parentheses/
     */
//    public static void main(String[] args) {
//
//        System.out.println(isValid("))"));
//        System.out.println(isValid("()[]{}"));
//    }
//

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for (char currChar : s.toCharArray()) {
            if (currChar == '(')
                stack.push(')');
            else if (currChar == '{')
                stack.push('}');
            else if (currChar == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != currChar)
                return false;
        }

        return stack.isEmpty();
    }
}
