package hackerRank.medium;

import interview.InterviewPractice;

import java.util.Arrays;

public class MaxMin {

    public static void main(String[] args) {
        int k = 2;
        int[] arr = {1, 4, 7, 2};

        System.out.println(maxMin(k, arr));
    }


    static int maxMin(int k, int[] arr) {

        int left = 0;
        int right = left + k;
        int unfairness = Integer.MAX_VALUE;

        Arrays.sort(arr);
        System.out.println("Array " + Arrays.toString(arr));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int a = left; a < right; a++) {
            System.out.println("Inside a loop " + a);
            min = Math.min(min, arr[a]);
            max = Math.max(max, arr[a]);
        }
        unfairness = Math.min(unfairness, max - min);

        left++;
        right = left + k;

        while (right <= arr.length) {

            System.out.println("LEFT " + left);
            System.out.println("RIGHT " + right);
            if (right == arr.length) {
                max = Math.max(max, arr[right-1]);
            }else {

                max = Math.max(max, arr[right]);
            }
            min = Math.min(min, arr[left]);

            unfairness = Math.min(unfairness, max - min);
            System.out.println("Unfairness " + unfairness);
            left++;
            right = left + k;
        }

        return unfairness;
    }
}
