package hackerRank.newImplemenations;

import java.util.Arrays;
import java.util.List;

public class TheBirthdayBar {

    /**
//     * https://www.hackerrank.com/challenges/the-birthday-bar
//     */
//    public static void main(String[] args) {
//
//        System.out.println(birthday(Arrays.asList(2,2,1,3,2),4,2));
//    }


    public static int birthday(List<Integer> s, int d, int m) {

        int count = 0;
        for (int a = 0; a <= s.size() - m; a++) {
            int currCount = 0;
            for (int b = a; b < a + m; b++) {
                currCount += s.get(b);
            }
            if (currCount == d) count++;
        }
        return count;
    }


}
