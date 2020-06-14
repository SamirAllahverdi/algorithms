package hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 3};
        insertionSort1(5, array);
    }


    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int mem = arr[arr.length - 1];

        IntStream.range(0, arr.length - 1).boxed().sorted(Collections.reverseOrder()).forEach(e -> {
            if (mem < arr[e]) {
                swap(mem, e, arr);
                Last.last = e;
            }
        });
        arr[Last.last] = mem;
     print(arr);

    }

    static class Last {
        static int last;
    }


    private static void swap(int mem, int b, int[] arr) {
        arr[b + 1] = arr[b];
        print(arr);

    }

    private static void print(int[] arr) {
        IntStream.range(0,arr.length).forEach(a-> System.out.print(a+" "));
        System.out.println();
    }


}

