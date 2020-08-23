package hackerRank.medium;

import java.util.HashMap;
import java.util.Map;

public class BearAndSteadyGene {

    /**
     * https://www.hackerrank.com/challenges/bear-and-steady-gene/problem
     */


    public static void main(String[] args) {

        String gene = "GAAATAAA";
        System.out.println(steadyGene(gene));
    }

    public static boolean balanced(int N, Map<Character, Integer> map) {
        return map.get('A') <= N && map.get('C') <= N && map.get('G') <= N
                && map.get('T') <= N;
    }

    public static int steadyGene(String s) {
        int N = s.length() / 4;
        Map<Character, Integer> map = fillHashMap(s);

        int min = Integer.MAX_VALUE;

        int i = 0, j = 0;

        while (i < s.length() && j < s.length()) {
            if (!balanced(N, map)) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                j++;
            } else {
                min = Math.min(min, j - i);
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                i++;
            }
        }

        return min;
    }

    private static Map<Character, Integer> fillHashMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        s.chars().forEach(a -> map.put((char) a, map.get((char) a) + 1));

        return map;
    }
}
