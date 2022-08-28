package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class BreakingWorstAndBestRecords {




    /**
     * - https://www.hackerrank.com/challenges/breaking-best-and-worst-records
     */


//    public static void main(String[] args) {
//
//        System.out.println(breakingRecords(Arrays.asList(12, 24, 10, 24)));
//    }


    public static List<Integer> breakingRecords(List<Integer> scores) {

        int max = scores.get(0);
        int min = scores.get(0);

        int breakMax = 0;
        int breakMin = 0;

        for (int score : scores) {
            if (score > max) {
                max = score;
                breakMax++;
            }
            if (score < min) {
                min = score;
                breakMin++;
            }
        }

        return Arrays.asList(breakMax, breakMin);
    }
}
