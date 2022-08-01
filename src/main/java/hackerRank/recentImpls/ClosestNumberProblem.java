package hackerRank.recentImpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestNumberProblem {
    /**
     * https://www.hackerrank.com/challenges/closest-numbers/
     */
//    public static void main(String[] args) {
//        System.out.println(closestNumbers(Arrays.asList(5, 3, 4, 2)));
//    }


    public static List<Integer> closestNumbers(List<Integer> arr) {

        Collections.sort(arr);

        List<Integer> pairs = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        for (int a = 1; a < arr.size(); a++)
            min = Math.min(min, Math.abs(arr.get(a) - arr.get(a - 1)));


        for (int a = 1; a < arr.size(); a++) {
            if (Math.abs(arr.get(a) - arr.get(a - 1)) == min) {
                pairs.add(arr.get(a - 1));
                pairs.add(arr.get(a));
            }
        }

        return pairs;
    }
}
