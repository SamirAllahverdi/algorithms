package hackerRank.easy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunnyString {
    /**
     * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
     */
    public static void main(String[] args) {
        String a = "acxz";
        String b ="bcxz";
        System.out.println(funnyStringWithStream(b));
        System.out.println(funnyStringWithStreamOptimized(b));
    }


    static String funnyStringWithStream(String s) {

        List<Integer> order = IntStream.range(0, s.length() - 1).boxed().map(a -> Math.abs(s.charAt(a) - s.charAt(a + 1))).collect(Collectors.toList());
        List<Integer> reverseOrder = IntStream.range(1, s.length()).boxed().sorted(Comparator.reverseOrder()).map(a -> Math.abs(s.charAt(a) - s.charAt(a - 1))).collect(Collectors.toList());

        return order.equals(reverseOrder) ? "Funny" : "Not Funny";
    }

    static String funnyStringWithStreamOptimized(String s) {
        return IntStream.range(0, s.length() - 1).allMatch(i-> Math.abs(s.charAt(i) - s.charAt(i+1)) == Math.abs(s.charAt(s.length()-i-1) - s.charAt(s.length()-i-2))) ? "Funny" : "Not Funny";
    }
}
