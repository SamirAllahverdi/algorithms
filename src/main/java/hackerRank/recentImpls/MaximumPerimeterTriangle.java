package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumPerimeterTriangle {


    /*
     * https://www.hackerrank.com/challenges/maximum-perimeter-triangle
     */

//    public static void main(String[] args) {
//
//        System.out.println(maximumPerimeterTriangle(Arrays.asList(1, 4, 51, 32)));
//    }


    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {

        Collections.sort(sticks);

        for (int a = sticks.size() - 1; a > 1; a--) {
            if (sticks.get(a) < sticks.get(a - 2) + sticks.get(a - 1)) {
                return List.of(sticks.get(a - 2), sticks.get(a - 1), sticks.get(a));
            }
        }

        return List.of(-1);


    }
}
