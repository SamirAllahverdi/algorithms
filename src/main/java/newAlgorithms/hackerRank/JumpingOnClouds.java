package newAlgorithms.hackerRank;

import java.util.Arrays;
import java.util.List;

public class JumpingOnClouds {

    /**
     * https://www.hackerrank.com/challenges/jumping-on-the-clouds
     */
    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(Arrays.asList(0, 0, 1, 0, 0, 1 ,0))); //4
        System.out.println(jumpingOnClouds(Arrays.asList(0 ,0 ,0 ,0, 1 ,0)));  //3
    }

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;

        for (int i = 0; i < c.size() - 1; i++) {
            jumps++;
            if (i + 2 < c.size() && c.get(i + 2) == 0) {
                i++;
            }
        }
        return jumps;

    }
}
