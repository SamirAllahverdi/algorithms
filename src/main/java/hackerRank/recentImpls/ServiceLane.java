package hackerRank.recentImpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceLane {

    /**
     * - https://www.hackerrank.com/challenges/service-lane
     */
//    public static void main(String[] args) {
//        List<List<Integer>> cases = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(4, 6));
//        System.out.println(serviceLane(Arrays.asList(2, 3, 1, 2, 3, 2, 3, 3), 8, cases));
//    }


    public static List<Integer> serviceLane(List<Integer> width, int n, List<List<Integer>> cases) {

        List<Integer> list = new ArrayList<>();
        for (List<Integer> aCase : cases) {
            int min = Integer.MAX_VALUE;
            for (int b = aCase.get(0); b <= aCase.get(1); b++)
                min = Math.min(min, width.get(b));

            list.add(min);
        }

        return list;
    }
}
