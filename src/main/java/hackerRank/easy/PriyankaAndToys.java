package hackerRank.easy;

import java.util.Arrays;

public class PriyankaAndToys {

    /**
     * https://www.hackerrank.com/challenges/priyanka-and-toys/problem
     */

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 21, 7, 12, 14, 21};

        System.out.println(toys(weights));
    }

    static int toys(int[] w) {
        Arrays.sort(w);
        int c = 1, lim = 0;

        for (int i = 0; i < w.length; i++) {
            if (w[i] - w[lim] > 4) {
                lim = i;
                c++;
            }
        }
        return c;
    }

}
