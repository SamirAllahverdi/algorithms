package hackerRank.easy;

import java.util.Arrays;

public class MinimumAbsoluteDifference {

    /**
     * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
     **/

    public static void main(String[] args) {
        int arr[] = {};
        System.out.println(minimumAbsoluteDifference(arr));

    }


    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        return minDiff(arr);
    }

    private static int minDiff(int[] arr) {
        int absDiff = Integer.MAX_VALUE;
        for (int a = 0; a < arr.length ; a++) {

                absDiff = Math.min(absDiff, Math.abs(arr[a] - arr[a+1]));

        }
        return absDiff;
    }

}
