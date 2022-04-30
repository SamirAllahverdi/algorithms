package sorting;

import java.util.Arrays;

public class QuickSort {


    // Best: O(nlog(n)) time | O(log(n)) space
    // Average: O(Nlog(n)) time | O(log(n)) space
    // Worst: O(n^2) time | O(log(n)) space


    public static void main(String[] args) {


        int[] array = {22, 10, 3, 4, 1, 7};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }


    public static void quicksort(int[] array, int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;


        int pivotIdx = startIdx;

        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;

        while (rightIdx >= leftIdx) {
            if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(leftIdx, rightIdx, array);
            }
            if (array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            }
            if (array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }

        swap(pivotIdx, rightIdx, array);

        quicksort(array, rightIdx + 1, endIdx);
        quicksort(array, startIdx, rightIdx - 1);

    }


    private static void swap(int second, int first, int[] array) {
        int temp = array[second];
        array[second] = array[first];
        array[first] = temp;
    }
}
