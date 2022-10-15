package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class LonelyInteger {


    /**
     * -https://www.hackerrank.com/challenges/lonely-integer/
     */

//    public static void main(String[] args) {
//        System.out.println(lonelyinteger(Arrays.asList(1, 4, 31, 31, 4)));
//    }

    public static int lonelyinteger(List<Integer> numbers) {

        int[] numbersCount = new int[101];

        for (Integer number : numbers) {
            numbersCount[number]++;
        }

        for (int a = 0; a < numbersCount.length; a++) {
            if (numbersCount[a] == 1) {
                return a;
            }
        }

        throw new IllegalArgumentException();
    }

}
