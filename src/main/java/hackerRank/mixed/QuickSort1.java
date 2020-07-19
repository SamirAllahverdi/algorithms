package hackerRank.mixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class QuickSort1 {

    public static void main(String[] args) {

        int[] array = {4, 5, 4, 5, 3, 7};


        System.out.println(Arrays.toString(quickSort2(array)));
    }


    static int[] quickSort(int[] arr) {

        List<Integer> left = new ArrayList<>();

        List<Integer> equal = new ArrayList<>();

        List<Integer> right = new ArrayList<>();


        IntStream.range(1, arr.length).forEach(a -> {
            if (arr[a] > arr[0]) {
                right.add(arr[a]);
            } else if (arr[a] < arr[0]) {
                left.add(arr[a]);

            } else {
                equal.add(arr[a]);

            }
        });

        List<Integer> result = new ArrayList<>();
        result.addAll(left);
        result.addAll(equal);
        result.addAll(right);

        return result.stream().mapToInt(a -> a).toArray();
    }
    static int[] quickSort2(int[] arr) {
        int[] left = new int[arr.length - 1];
        int[] right = new int[arr.length - 1];
        int l = 0;
        int r = 0;
        int mid = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[0] > arr[i]) {
                left[l++] = arr[i];
            } else {
                right[r++] = arr[i];
            }
        }
        for (int i = 0; i < l; i++) {
            arr[i] = left[i];
        }
        for (int i = 0; i < r; i++) {
            arr[i + l + 1] = right[i];
        }
        arr[l] = mid;
        return arr;
    }


}