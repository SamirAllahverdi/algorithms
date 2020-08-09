package hackerRank.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class BeautifulPairs {
    /**
     * https://www.hackerrank.com/challenges/beautiful-pairs/problem
     */
    public static void main(String[] args) {
        int[] a = {3, 4, 1, 2};
        int[] b = {3, 5, 1, 2};
//        FOR FIRST
        System.out.println(beautifulPairs(a, b));
//        FOR SECOND
        System.out.println(beautifulPairs2(a, b));
    }

    /**
     * - FIRST SOLUTION -
     */
    static int beautifulPairs(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int leftIdx = 0;
        int rightIdx = 0;

        int count = 0;
        while (leftIdx < A.length && rightIdx < B.length) {
            if (A[leftIdx] > B[rightIdx]) {
                rightIdx++;
            } else if (A[leftIdx] < B[rightIdx]) {
                leftIdx++;
            } else {
                count++;
                leftIdx++;
                rightIdx++;
            }
        }
        return count != A.length ? count + 1 : count - 1;
    }


    /**
     * - SECOND SOLUTION -
     */
    static int beautifulPairs2(int[] A, int[] B) {
        int[] bucketA = new int[1000 + 1];

        for (int value : A) {
            bucketA[value]++;
        }

        int count = 0;
        for (int value : B) {
            if (bucketA[value] > 0) {
                bucketA[value]--;
                count++;
            }
        }

        return count == B.length ? count - 1 : count + 1;
    }
}
