package hackerRank.newImplemenations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {

    /**
     * https://www.hackerrank.com/challenges/picking-numbers
     */
//    public static void main(String[] args) {
//        System.out.println(pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2)));
//    }


    public static int pickingNumbers(List<Integer> a) {

        int[] frequency = new int[101];
        int result = Integer.MIN_VALUE;

        for (int index : a) {
            frequency[index]++;
        }

        for (int i = 1; i <= 100; i++) {
            result = Math.max(result, frequency[i] + frequency[i - 1]);
        }
        return result;
    }

}
