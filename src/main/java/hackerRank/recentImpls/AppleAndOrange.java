package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class AppleAndOrange {


    /**
     * https://www.hackerrank.com/challenges/apple-and-orangev
     */

//    public static void main(String[] args) {
//        countApplesAndOranges(7,11,5,15, Arrays.asList(-2,2,1),Arrays.asList(5,-6));
//    }


    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {

        int houseApple = 0;

        for (int apple : apples) {
            int d = a + apple;
            if (d >= s && d <= t)
                houseApple++;
        }

        int houseOrange = 0;
        for (int orange : oranges) {
            int d = b + orange;
            if (d >= s && d <= t)
                houseOrange++;
        }

        System.out.println(houseApple);
        System.out.println(houseOrange);

    }
}
