package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PriyankaAndToys {
    /**
     * - https://www.hackerrank.com/challenges/priyanka-and-toys
     */

//    public static void main(String[] args) {
//
////        System.out.println(toys(Arrays.asList(1, 2, 3, 4, 7, 2, 3)));
//    }
    public static int toys(List<Integer> weights) {

        Collections.sort(weights);

        int count = 1;
        int first = weights.get(0);

        for (int a = 1; a < weights.size(); a++) {
            Integer weight = weights.get(a);
            if (first + 4 < weight) {
                first = weight;
                count++;
            }
        }

        return count;
    }

}
