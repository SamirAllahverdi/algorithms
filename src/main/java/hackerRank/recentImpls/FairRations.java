package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class FairRations {

    /**
     * https://www.hackerrank.com/challenges/fair-rations
     */
//    public static void main(String[] args) {
//        List<Integer> loaves = Arrays.asList(2, 3, 4, 5, 6);
//        System.out.println(fairRations(loaves));
//    }


    public static String fairRations(List<Integer> loaves) {

        int loave = -1;
        int bread = 0;

        for (int a = 0; a < loaves.size() - 1; a++) {
            int curr = loave > -1 ? loave : loaves.get(a);
            if (!isEven(curr)) {
                loave = loaves.get(a + 1) + 1;
                bread += 2;
            } else {
                loave = -1;
            }
        }

        int last = (loave > -1) ? loave : loaves.get(loaves.size() - 1);
        return !isEven(last) ? "NO" : String.valueOf(bread);
    }


    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
