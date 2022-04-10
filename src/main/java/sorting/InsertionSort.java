package sorting;

import java.util.Arrays;

public class InsertionSort {

      // Best: O(n) time | O(1) space
      // Average: O(n^2) time | O(1) space
      // Worst: O(n^2) time | O(1) space
//    public static void main(String[] args) {
//        int[] array = {3, 4, 1, 7};
//        System.out.println(Arrays.toString(insertionSor(array)));
//    }


    public static int[] insertionSor(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }

        for (int a = 1; a < array.length; a++) {
            int b = a;
            while (b > 0 && array[b] < array[b - 1]) {
                swap(b, b - 1, array);
                b--;
            }
        }

        return array;
    }

    private static void swap(int second, int first, int[] array) {
        int temp = array[second];
        array[second] = array[first];
        array[first] = temp;
    }
}
