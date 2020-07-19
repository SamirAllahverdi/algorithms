package hackerRank.mixed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class WeightedUniformStrings {
    public static void main(String[] args) {
        String s = "abccddde";
        int[] queries = {1, 3, 12, 5, 9, 10};

        System.out.println(Arrays.toString(weightedUniformStrings(s, queries)));

    }


    static String[] weightedUniformStrings(String s, int[] queries) {

        int temp = 0;

        Set<Integer> hashSets = new HashSet<>();
        for (int a = 0; a < s.length(); a++) {
            if (a == 0 || s.charAt(a) != s.charAt(a - 1)) {
                temp = s.charAt(a) - 'a' + 1;
            } else {
                temp += s.charAt(a) - 'a' + 1;
            }
            hashSets.add(temp);
        }


        return IntStream.range(0, queries.length).boxed().map(a -> {
            if (hashSets.contains(queries[a])) {
                return "YES";
            } else {
                return "NO";
            }

        }).toArray(String[]::new);

    }



}
