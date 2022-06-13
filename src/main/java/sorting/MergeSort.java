package sorting;

import java.util.Arrays;

public class MergeSort {

    // Best: O(nlog(n)) time | O(n) space
    // Average: O(Nlog(n)) time | O(n) space
    // Worst: O(nLogn) time | O(n) space
    public static void main(String[] args) {
        int[] array = {22, 10, 3, 4, 1, 7};
        System.out.println(Arrays.toString(mergeSortBasic(array)));

    }

    public static int[] mergeSortBasic(int[] array) {
        if (array.length <= 1)
            return array;

        int middleIdx = (array.length / 2);
        int[] leftHalf = Arrays.copyOfRange(array, 0, middleIdx);
        int[] rightHalf = Arrays.copyOfRange(array, middleIdx, array.length);

        return mergeSortedArrays(mergeSortBasic(leftHalf), mergeSortBasic(rightHalf));
    }

    private static int[] mergeSortedArrays(int[] leftHalf, int[] rightHalf) {
        int[] sortedArray = new int[leftHalf.length + rightHalf.length];

        int leftHalfIdx = 0;
        int rightHalfIdx = 0;
        int sortedArrayIdx = 0;


        while (leftHalfIdx < leftHalf.length && rightHalfIdx < rightHalf.length) {
            if (leftHalf[leftHalfIdx] <= rightHalf[rightHalfIdx])
                sortedArray[sortedArrayIdx++] = leftHalf[leftHalfIdx++];
            else
                sortedArray[sortedArrayIdx++] = rightHalf[rightHalfIdx++];
        }

        while (leftHalfIdx < leftHalf.length)
            sortedArray[sortedArrayIdx++] = leftHalf[leftHalfIdx++];


        while (rightHalfIdx < rightHalf.length)
            sortedArray[sortedArrayIdx++] = rightHalf[rightHalfIdx++];

        return sortedArray;
    }


}
