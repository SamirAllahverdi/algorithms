package hackerRank.medium;

import java.util.*;

public class Pairs {
    /**
     * https://www.hackerrank.com/challenges/pairs/problem
     */

    public static void main(String[] args) {
        int k = 1;
        int[] arr = {1, 2, 3};

//    FOR FIRST SOLUTION
        System.out.println(pairs(k, arr));

//    FOR SECOND SOLUTION
        System.out.println(pairs2(k, arr));

    }

    /**
     *  - FIRST SOLUTION -
     */
    static int pairs(int k, int[] arr) {

        HashSet<Integer> set = fillHashSet(arr);
        int count = 0;

        for (int i : arr) {

            int value = i + k;

            if (set.contains(value)) {
                count++;
            }
        }

        return count;
    }

    private static HashSet<Integer> fillHashSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            set.add(i);
        }

        return set;
    }

    /**
     *  - SECOND SOLUTION -
     */
    static int pairs2(int k, int[] arr) {
        Arrays.sort(arr);

        int i = 0, j = 1, count = 0;

        while (j < arr.length) {

            int diff = arr[j] - arr[i];

            if (diff == k) {
                count++;
                j++;
                i++;
            } else if (diff > k) {
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
}
