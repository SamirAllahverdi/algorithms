package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarcsCakewalk {

    /**
     * - https://www.hackerrank.com/challenges/marcs-cakewalk
     */
//    public static void main(String[] args) {
//        System.out.println(marcsCakewalk(Arrays.asList(1, 3, 2, 7)));
//    }
    public static long marcsCakewalk(List<Integer> calorie) {

        Collections.sort(calorie);
        int n = calorie.size();

        long miles = 0;
        long prePower = 1;

        for (int a = n - 1; a >= 0; a--) {
            if (a != n - 1)
                prePower *= 2;

            miles += prePower * calorie.get(a);
        }

        return miles;
    }
}
