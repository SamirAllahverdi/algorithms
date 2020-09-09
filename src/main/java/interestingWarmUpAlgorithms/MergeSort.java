package interestingWarmUpAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
// create a random array
        int[] data = {4, 5, 1, 2, 7, 2, 3, 4};
        // make a copy not to mutate original data
        int[] sorted = data.clone();
        int[] sorted2 = data.clone();
        // create the new instance of our class
        // running sort
        mergeSort(sorted);
        mergeSort2(sorted2);
        // print
        System.out.printf("Source array: %s\n", Arrays.toString(data));
        System.out.println("Merge sort: complexity: O(n*log(N)), space:O(n*log(N)) ");
        System.out.printf("Sorted array: %s\n", Arrays.toString(sorted));
        System.out.println("Merge sort: complexity: O(n*log(N)),  space:O(n)");
        System.out.printf("Sorted array: %s\n", Arrays.toString(sorted2));
    }

    //    complexity: O(n*log(N)),  space:O(n)"
    private static void mergeSort2(int[] sorted2) {
        if (sorted2.length == 1) return;
        int[] auxiliary = sorted2.clone();
        mergeSortHelper(sorted2, 0, sorted2.length - 1, auxiliary);
    }
    private static void mergeSortHelper(int[] array, int leIdx, int riIdx, int[] auxiliary) {
        if (leIdx == riIdx) {
            return;
        }
        int mid = (leIdx + riIdx) / 2;
        mergeSortHelper(array, leIdx, mid, array);
        mergeSortHelper(array, mid + 1, riIdx, array);
        dohelper(array, leIdx, mid, riIdx, auxiliary);
    }
    private static void dohelper(int[] array, int leIdx, int mid, int riIdx, int[] auxiliary) {
        int left = leIdx;
        int right = mid + 1;
        int k = leIdx;
// here must be <=  because mid is also index itself as well as riIndex
        while (left <= mid && right <= riIdx) {
            if (auxiliary[left] <= auxiliary[right]) {

                array[k] = auxiliary[left];
                left++;
            } else {
                array[k] = auxiliary[right];
                right++;
            }
            k++;
        }
        while (left <= mid) {
            array[k] = auxiliary[left];
            left++;
            k++;
        }
        while (right <= riIdx) {
            array[k] = auxiliary[right];
            right++;
            k++;
        }

    }

    //    complexity:   O(n*log(N)), space:O(n*log(N))
    private static void mergeSort(int[] sorted) {
        split(sorted, 0, sorted.length - 1);
    }

    private static void split(int[] sorted, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            split(sorted, left, mid);
            split(sorted, mid + 1, right);
            merge(sorted, left, mid, right);
        }
    }

    private static void merge(int[] sorted, int left, int mid, int right) {
//        it defines sizes of leftArray. as it start frm 0. we add +1
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
// create array
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
// fill array
        for (int a = 0; a < leftArray.length; a++) {
            leftArray[a] = sorted[left + a];
        }
        for (int a = 0; a < rightArray.length; a++) {
//       leftArray=  (left ... mid) , rightArray = ((mid+1)....right)
            rightArray[a] = sorted[mid + 1 + a];
        }
        int l = 0;
        int r = 0;

//        sorted array starting point, it defines where we will begin
        int k = left;
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                sorted[k] = leftArray[l];
                l++;
            } else {
                sorted[k] = rightArray[r];
                r++;
            }
            k++;
        }

        while (l < leftSize) {
            sorted[k] = leftArray[l];
            l++;
            k++;
        }

        while (r < rightSize) {
            sorted[k] = rightArray[r];
            r++;
            k++;
        }

    }


}
