package newImplemenations.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AcmPcpcTeam {
    /**
     * https://www.hackerrank.com/challenges/acm-icpc-team
     */
//    public static void main(String[] args) {
//
//        System.out.println(
//                acmTeam(4, Arrays.asList("10101", "11100", "11010", "00101")));
////        expected [5,2]
//    }


    public static List<Integer> acmTeam(int n, List<String> topic) {

        int max = Integer.MIN_VALUE;
        int team = 0;
        for (int a = 0; a < n - 1; a++) {
            String first = topic.get(a);
            for (int b = a + 1; b < n; b++) {
                String second = topic.get(b);

                int count = 0;
                for (int k = 0; k < first.length(); k++) {
                    if (first.charAt(k) == '1' || second.charAt(k) == '1')
                        count++;
                }

                if (max < count) {
                    max = count;
                    team = 1;
                } else if (max == count) {
                    team++;
                }
            }
        }

        return Arrays.asList(max, team);
    }
}
