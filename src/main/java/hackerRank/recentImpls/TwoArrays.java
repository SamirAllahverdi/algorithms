package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoArrays {

    /**
     * https://www.hackerrank.com/challenges/two-arrays
     */
//    public static void main(String[] args) {
//
//        System.out.println(twoArrays(10, Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 5)));
//    }


    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {

        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        for (int a = 0; a < A.size(); a++) {
            if (A.get(a) + B.get(a) < k)
                return "NO";
        }
        return "YES";
    }
}
