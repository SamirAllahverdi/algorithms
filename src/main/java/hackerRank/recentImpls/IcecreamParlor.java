package hackerRank.recentImpls;

import java.util.*;

public class IcecreamParlor {


    /**
     * - https://www.hackerrank.com/challenges/icecream-parlor
     */
//    public static void main(String[] args) {
//        System.out.println(icecreamParlor(4, Arrays.asList(2, 2, 3, 4, 5)));
//    }


    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a = 0; a < arr.size(); a++) {
            int other = m - arr.get(a);
            if (map.containsKey(other))
                return Arrays.asList(Math.min(map.get(other), a + 1), Math.max(map.get(other), a + 1));
            map.put(arr.get(a), a + 1);
        }

        return Collections.emptyList();

    }
}
