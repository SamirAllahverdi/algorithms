package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class BirthdayCakeCandle {

    /**
     * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
     */
//    public static void main(String[] args) {
//        List<Integer> candles = Arrays.asList(3, 3, 2, 1);
//        System.out.println(birthdayCakeCandles(candles));
//    }


    public static int birthdayCakeCandles(List<Integer> candles) {

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int candle : candles) {
            if (max == candle) {
                count++;
            } else if (max < candle) {
                max = candle;
                count = 1;
            }
        }
        return count;

    }
}
