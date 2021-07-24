package newImplemenations.hackerRank;

import java.util.Collections;
import java.util.List;

public class AngryChildren {

    /***
     * https://www.hackerrank.com/challenges/angry-children
     */

//    public static void main(String[] args) {
//
//        System.out.println(maxMin(3, Arrays.asList( 10, 100, 300, 200, 1000, 20, 30))); /* expected 20 */
//    }


    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int minAbsoluteDiff = Integer.MAX_VALUE;
        for (int a = 0; a < arr.size() - k + 1; a++) {
            int currAbsoluteDiff = arr.get(a + k - 1) - arr.get(a);
            minAbsoluteDiff = Math.min(minAbsoluteDiff, currAbsoluteDiff);
        }

        return minAbsoluteDiff;
    }

}
