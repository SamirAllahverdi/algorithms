package hackerRank.recentImpls;

import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {

    /**
     * - https://www.hackerrank.com/challenges/missing-numbers
     */
//    public static void main(String[] args) {
//        System.out.println(missingNumbers(Arrays.asList(1, 2, 2, 4), Arrays.asList(1, 2, 3,4)));
//    }


    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        int[] array = new int[100];

        int min = Integer.MAX_VALUE;
        for (int el : brr)
            min = Math.min(el, min);

        for (int el : brr)
            array[el - min] += 1;

        for (int el : arr)
            array[el - min] -= 1;


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++)
            if (array[i] > 0)
                list.add(min + i);


        return list;
    }

}