package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class MiniMaxSum {

    /**
     * https://www.hackerrank.com/challenges/mini-max-sum
     */

//    public static void main(String[] args) {
//        miniMaxSum(Arrays.asList(1,4,5,6));
//    }

    public static void miniMaxSum(List<Integer> arr) {

        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;


        long sum = 0;
        for (int el : arr) {
            sum += el;

            max = Math.max(max, el);
            min = Math.min(min, el);
        }

        System.out.println((sum - max) + " " + (sum - min));
    }
}
