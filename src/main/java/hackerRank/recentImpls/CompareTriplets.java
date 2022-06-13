package hackerRank.recentImpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareTriplets {

    /**
     * - https://www.hackerrank.com/challenges/compare-the-triplets
     */

    public static void main(String[] args) {
        System.out.println(compareTriplets(Arrays.asList(3,2,1),Arrays.asList(4,4,3)));
    }

    public static List<Integer> compareTriplets(List<Integer> c, List<Integer> b) {
        int alicePoints = 0;
        int bobPoints = 0;

        for (int a = 0; a < c.size(); a++) {
            if (c.get(a) > b.get(a))
                alicePoints++;

            if (c.get(a) < b.get(a))
                bobPoints++;
        }

        return Arrays.asList(alicePoints, bobPoints);
    }

}
