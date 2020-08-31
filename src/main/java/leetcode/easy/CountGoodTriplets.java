package leetcode.easy;

import java.util.Arrays;

public class CountGoodTriplets {


    public static void main(String[] args) {

    }


    public static int countGoodTriplets(int[] arr, int a, int b, int c) {


        int left = 0;
        int mid = 1;
        int right = 2;
        int count = 0;
        while (left < right) {

            int[] array = {arr[0], arr[1], arr[2]};

            if (isValid(array, a, b, c) == 0) count++;




        }

return count;
    }

    private static int isValid(int[] array, int a, int b, int c) {

        if (Math.abs(array[0] - array[1]) > a) return 1;
        else if (Math.abs(array[1] - array[2]) > b) return 2;
        else if (Math.abs(array[0] - array[2]) > c) return 3;

        return 0;
    }
}
