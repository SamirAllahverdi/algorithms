package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class DivisibleSumPairs {

/**
 * https://www.hackerrank.com/challenges/divisible-sum-pairs
 */

//    public static void main(String[] args) {
//        System.out.println(divisibleSumPairs(4,2, Arrays.asList(1,2,3,4)));
//    }

    public static int divisibleSumPairs(int n, int k, List<Integer> arr) {
        int count = 0;

        for (int a = 0; a < n - 1; a++) {
            for (int b = a + 1; b < n; b++) {
                if ((arr.get(a) + arr.get(b)) % k == 0)
                    count++;
            }
        }


        return count;
    }
}
