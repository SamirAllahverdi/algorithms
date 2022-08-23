package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class TheHurdleRace {
    /**
     * - https://www.hackerrank.com/challenges/the-hurdle-race
     */

//    public static void main(String[] args) {
//
//
//        System.out.println(hurdleRace(3, Arrays.asList(1, 3, 4, 5)));
//    }

    public static int hurdleRace(int k, List<Integer> heights) {

        int max = Integer.MIN_VALUE;

        for (int height : heights)
            max = Math.max(max, height);

        return Math.max(max - k, 0);
    }


}
