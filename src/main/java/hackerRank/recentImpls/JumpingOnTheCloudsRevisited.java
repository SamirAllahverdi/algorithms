package hackerRank.recentImpls;

import java.util.Arrays;

public class JumpingOnTheCloudsRevisited {
    /*
     * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/
     */
//    public static void main(String[] args) {
//        int[] array = {0, 1, 0, 1, 1};
//
//        System.out.println(jumpingOnClouds(array, 2));
//    }

    static int jumpingOnClouds(int[] c, int k) {

        int n = c.length;
        int energy = 100;
        int idx = k;

        energy -= 1;
        if (c[idx] == 1) {
            energy -= 2;
        }


        while (idx != 0) {
            idx = (idx + k) % n;

            energy -= 1;
            if (c[idx] == 1) {
                energy -= 2;
            }
        }
        return energy;
    }


}
