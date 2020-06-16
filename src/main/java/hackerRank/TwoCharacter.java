package hackerRank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoCharacter {
    public static void main(String[] args) {
        String a = "beabeefeab";
        System.out.println(alternateWithFor(a));
    }


    static int alternateWithFor(String s) {
        if (s.length() == 1) return 0;
        List<Character> collect = s.codePoints().distinct().mapToObj(a -> (char) (a)).collect(Collectors.toList());
        if (collect.size() == 1) return 0;
        int longestString = Integer.MIN_VALUE;

        for (int a = 0; a < collect.size() - 1; a++) {
            for (int b = a + 1; b < collect.size(); b++) {
                int size = helper(collect.get(a), collect.get(b), s);
                if (longestString < size) {
                    longestString = size;
                }
            }
        }
        return longestString;
    }

    private static int helper(Character first, Character second, String s) {
        List<Character> collect = IntStream.range(0, s.length()).boxed().map(s::charAt).filter(a -> a.equals(first) || a.equals(second)).collect(Collectors.toList());
        return IntStream.range(0, collect.size() - 1).allMatch(e -> !collect.get(e).equals(collect.get(e + 1))) ? collect.size() : 0;
    }


}
