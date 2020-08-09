package hackerRank.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BeautifulPairs {
    /**
     * https://www.hackerrank.com/challenges/beautiful-pairs/problem
     */
    public static void main(String[] args) {
        int[] a = {3, 4, 1, 2,2,5,5};
        int[] b = {3, 5, 1, 2,2,5,9};
        System.out.println(beautifulPairs(a, b));
    }


    static int beautifulPairs(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        System.out.println("After Sorting ");
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

        int left = 0;
        int right = 0;

        int count = 0;
        while (left < A.length-1 && right < B.length) {
            System.out.println("t");
            if (A[left] > B[right]) {
                right++;
            } else if (A[left] < B[right]) {
                left++;
            } else {
                System.out.println( A[left] +" , " + A[left+1]);
                if (A[left] != A[left+1]) {
                    System.out.println("INSIDE IF " + A[left] +" , " + A[left+1]);
                    count++;
                }

                left++;
                right++;
            }
        }

        return count != A.length ? count + 1 : count;
    }
}
