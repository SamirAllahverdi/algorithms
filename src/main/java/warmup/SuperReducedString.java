package warmup;

import java.util.Stack;

public class SuperReducedString {

    public static void main(String[] args) {
        System.out.println(superReducedString("aabvs"));
    }

    static String superReducedString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            System.out.println(i + " TURN");
            char ch = str.charAt(i);
            System.out.println(stack.toString());
            if (!stack.isEmpty() && ch == stack.peek()) {
                System.out.println("Poped " + ch);
                stack.pop();
            } else {
                System.out.println("ADDED " + ch);
                stack.push(ch);
            }
            System.out.println("_________________________");
        }

        /* Print final result */
        if (stack.isEmpty()) {
            return "Empty String";
        } else {
            StringBuilder result = new StringBuilder();
            for (char ch : stack) {
                result.append(ch);
            }
            return result.toString();
        }
    }
}
