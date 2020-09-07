package InterestingWarmUpAlgorithms.Sherlock;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlockAndValidStringApp {

    public static void main(String[] args) {
        isValid("abbcc");
    }

    private final static String YES = "YES";
    private final static String NO = "NO";

    static class Pair<A, B> {
        final A a;
        final B b;

        Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }

    public static String isValid(String s) {
        Map<Character, Long> freq = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(freq);
        Map<Long, List<Character>> freqInv = freq.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toList())
                        )
                );


        List<Pair<Long, List<Character>>> m = freqInv.entrySet().stream()
                .map(e -> new Pair<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        m.forEach(a -> System.out.println(a.a + " / " + a.b));
        if (m.size() == 1) return YES;
        if (m.size() > 2) return NO;
        if (m.get(1).a - m.get(0).a == 1 && m.get(1).b.size() == 1) return YES;

        if (m.get(0).a == 1 && m.get(0).b.size() == 1) {
            return YES;
        }

        return NO;
    }


}
