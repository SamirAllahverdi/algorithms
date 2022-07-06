package hackerRank.recentImpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    /**
     * https://www.hackerrank.com/challenges/diagonal-difference
     */
//    public static void main(String[] args) {
//
//        List<List<Integer>> lists = Arrays.asList(
//                Arrays.asList(1, 2, 3),
//                Arrays.asList(4, 5, 6),
//                Arrays.asList(9, 8, 9)
//        );
//
//        System.out.println(diagonalDifference(lists));
//    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftDiagnoalSum = 0;
        int rightDiagnoalSum = 0;

        for (int a = 0; a < arr.size(); a++) {
            leftDiagnoalSum += arr.get(a).get(a);
            rightDiagnoalSum += arr.get(arr.size() - 1 - a).get(a);
        }

        return Math.abs(leftDiagnoalSum - rightDiagnoalSum);
    }
}
