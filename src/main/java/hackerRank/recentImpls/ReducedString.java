package hackerRank.recentImpls;

import java.util.Stack;
import java.util.stream.Collectors;

public class ReducedString {

    /**
     *  https://www.hackerrank.com/challenges/reduced-string
     */
//    public static void main(String[] args) {
//        System.out.println(superReducedString("aaabbc"));
//    }


    public static String superReducedString(String s) {

        Stack<Character> stack = new Stack<>();

        for (int a = 0; a < s.length(); a++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(a))
                stack.pop();
            else
                stack.push(s.charAt(a));
        }


        StringBuilder builder = new StringBuilder();
        for (Character ch : stack)
            builder.append(ch);


        String reducedString = builder.toString();
        return reducedString.isEmpty() ? "Empty String " : reducedString;
    }
}
