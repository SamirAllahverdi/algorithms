package sorting;

import java.util.Arrays;

public class BubbleSort {

    // Best: O(n) time | O(1) space
    // Average: O(n^2) time | O(1) space
    // Worst: O(n^2) time | O(1) space

    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 5, 6, 3, 9};

        System.out.println(Arrays.toString(bubbleSortImpl(nums)));
    }










    public static int[] bubbleSortImpl(int[] array) {

        if (array == null)
            return null;

        if (array.length == 0)
            return new int[0];

        for (int a = 0; a < array.length; a++) {
            boolean isSorted = true;
            for (int b = 0; b < array.length - 1 - a; b++) {
                if (array[b] > array[b + 1]) {
                    swap(b, b + 1, array);
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
        }


        return array;
    }


    public static int[] bubbleSort(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }

        boolean isSorted = false;
        int counter = 0;

        while (!isSorted) {
            isSorted = true;
            for (int a = 0; a < nums.length - 1 - counter; a++) {
                if (nums[a] > nums[a + 1]) {
                    swap(a, a + 1, nums);
                    isSorted = false;
                }
            }

            counter++;
        }

        return nums;
    }


    private static void swap(int f, int s, int[] nums) {
        int temp = nums[s];
        nums[s] = nums[f];
        nums[f] = temp;
    }

}
