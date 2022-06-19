package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HackerrankInAString {


    /**
     * - https://www.hackerrank.com/challenges/hackerrank-in-a-string/
     */
//    public static void main(String[] args) {
//        System.out.println(hackerrankInString("hereiamstackerrank"));
//    }


    public static String hackerrankInString(String s) {

        Queue<Character> queue = new LinkedList<>(
                Arrays.asList('h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k'));


        for (int a = 0; a < s.length(); a++) {
            if (s.charAt(a) == queue.peek())
                queue.poll();

            if (queue.isEmpty())
                return "YES";
        }


        return "NO";

    }
}
