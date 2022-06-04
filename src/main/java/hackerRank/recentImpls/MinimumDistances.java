package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistances {

    /**
     * https://www.hackerrank.com/challenges/minimum-distances/
     */

//    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(7, 1, 3, 1, 7);
//        System.out.println(minimumDistances(list));
//    }


    public static int minimumDistances(List<Integer> l) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a = 0; a < l.size(); a++) {
            if (map.containsKey(l.get(a)))
                min = Math.min(min, a - map.get(l.get(a)));
            map.put(l.get(a), a);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
