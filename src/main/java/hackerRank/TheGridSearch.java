package hackerRank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TheGridSearch {
    public static void main(String[] args) {

        String[] grid = {"7283455864", "6731158619", "8988242643", "3830589324", "2229505813", "5633845374", "6473530293", "7053106601", "0834282956", "4607924137"};
        String[] pattern = {"9505", "3845", "3530"};
        System.out.println(gridSearch(grid, pattern));
    }


    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
          return IntStream.rangeClosed(0, G.length - P.length).flatMap(a -> IntStream.rangeClosed(0, G[0].length() - P[0].length()).filter(b -> IsValidAt(a, b, G, P))).count() == 1?"YES":"NO";
    }

    private static boolean IsValidAt(int a, int b, String[] g, String[] p) {
        return IntStream.range(0,  p.length * p[0].length()).allMatch(e -> p[e/ p[0].length()].charAt(e % p[0].length()) == g[a + (e/  p[0].length())].charAt(b + (e % p[0].length())));
    }
}
