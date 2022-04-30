package sorting;

import java.util.Arrays;

public class SelectionSort {


    // Best: O(n^2) time | O(1) space
    // Average: O(n^2) time | O(1) space
    // Worst: O(n^2) time | O(1) space
//    public static void main(String[] args) {
//
//        int[] array = {3, 4, 1, 7, 2};
//        System.out.println(Arrays.toString(selectionSort(array)));
//    }





    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }

        for (int a = 0; a < array.length - 1; a++) {
            int smallestIdx = a;
            for (int b = a + 1; b < array.length; b++) {
                if (array[b] < array[smallestIdx]) {
                    smallestIdx = b;
                }
            }
            swap(a, smallestIdx, array);
        }

        return array;
    }

    private static void swap(int a, int b, int[] array) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
