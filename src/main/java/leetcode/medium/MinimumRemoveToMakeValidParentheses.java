package leetcode.medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    /**
     * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
     */

    public static void main(String[] args) {

        String s = "lee(t(c)o)de)";

        System.out.println(minRemoveToMakeValid(s));

    }

    /**
     * - first solution -
     */
    public static String minRemoveToMakeValid(String s) {
        StringBuilder st = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < st.length(); ++i) {
            if (st.charAt(i) == '(') stack.add(i);
            if (st.charAt(i) == ')') {
                if (!stack.empty()) stack.pop();
                else st.setCharAt(i, '*');
            }
        }
        while (!stack.empty())
            st.setCharAt(stack.pop(), '*');
        return st.toString().replaceAll("\\*", "");
    }

    /**
     * - second solution -
     */
    public static String minRemoveToMakeValid2(String s) {
        boolean[] b = new boolean[s.length()];

        StringBuilder st = new StringBuilder("");
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    b[i] = true;
                    Integer pop = stack.pop();
                    b[pop] = true;
                }
            } else {
                b[i] = true;
            }
        }

        for (int i = 0; i < s.length(); ++i) {
            if (b[i]) st.append(s.charAt(i));
        }

        return st.toString();
    }
}