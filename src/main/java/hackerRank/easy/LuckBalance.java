package hackerRank.easy;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class LuckBalance {
    /**
     * https://www.hackerrank.com/challenges/luck-balance/problem
     */
    public static void main(String[] args) {
        int[][] contest = {{5, 1},
                {2, 1},
                {1, 1},
                {8, 1},
                {10, 0},
                {5, 0}
        };
        int k = 3;
        System.out.println(luckBalance(k, contest));

    }

    static int luckBalance(int k, int[][] contests) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int[] contest : contests) {
            sum += contest[0];
            if (contest[1] == 1) {
                list.add(contest[0]);
            }
        }

        Collections.sort(list);


        int finalCount = list.size() - k - 1;

        while (finalCount > -1) {
            sum -= 2 * list.get(finalCount);
            finalCount--;
        }

        return sum;
    }


}
