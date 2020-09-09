package hackerRank.medium;


import java.util.Arrays;

public class MaxMin {

    /**
     * https://www.hackerrank.com/challenges/angry-children/problem
     */


    public static void main(String[] args) {
        int k = 4;
        int[] arr = {1, 2, 3, 4, 10, 20, 30, 40, 100, 200};
        // For first
        System.out.println(maxMin(k, arr));
        // For second
        System.out.println(maxMinOptimized(k, arr));
    }

    /**
     * - first solution -
     */
    static int maxMin(int k, int[] arr) {

        int left = 0;
        int right = left + k - 1;

        int unfairness = Integer.MAX_VALUE;

        Arrays.sort(arr);
        while (right < arr.length) {
            int min = arr[left];
            int max = arr[right];

            unfairness = Math.min(unfairness, max - min);

            left++;
            right = left + k - 1;
        }

        return unfairness;
    }

    /**
     * - second solution -
     */
    static int maxMinOptimized(int k, int[] arr) {
        int unfairness = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i <= arr.length - k; i++) {
            int currUnfairness = arr[i + k - 1] - arr[i];
            unfairness = Math.min(unfairness, currUnfairness);
        }
        return unfairness;
    }

}
