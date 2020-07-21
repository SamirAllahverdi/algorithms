package hackerRank.medium;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlockAndValidString {

    /**
     * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
     */

    public static void main(String[] args) {
        String st = "abbcc";
        System.out.println(isValid(st));

    }

    static class Pair<A, B> {
        final A a;
        final B b;

        Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }
    private static List<Pair<Long, List<Character>>> prepareData(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toList()
                        )
                ))
                .entrySet().stream()
                .map(e -> new Pair<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private static boolean solve(List<Pair<Long, List<Character>>> m) {
        if (m.size() == 1) return true;
        if (m.size() > 2) return false;
        if (m.get(1).a - m.get(0).a == 1 && m.get(1).b.size() == 1) return true;
        return m.get(0).a == 1 && m.get(0).b.size() == 1;
    }

    private static String represent(boolean solution) {
        return solution ? "YES" : "NO";
    }

    public static String isValid(String s) {
        List<Pair<Long, List<Character>>> m = prepareData(s);
        boolean solved = solve(m);
        return represent(solved);
    }

}
