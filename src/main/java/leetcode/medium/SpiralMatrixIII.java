package leetcode.medium;

import java.util.Arrays;

public class SpiralMatrixIII {


    /**
     * https://leetcode.com/problems/spiral-matrix-iii/
     */

    public static void main(String[] args) {
        int R = 5;
        int C = 6;
        int r0 = 1;
        int c0 = 4;

        Arrays.stream(spiralMatrixIII(R, C, r0, c0))
                .forEach(a -> System.out.println(Arrays.toString(a)));

    }


    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] results = new int[R * C][2];

        int len = 0, d = 0, j = 0;
        results[j++] = new int[]{r0, c0};

        while (j < R * C) {

            if (d == 0 || d == 2) {
                len++;
            }

            for (int i = 0; i < len; i++) {

                r0 += dirs[d][0];
                c0 += dirs[d][1];

                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                    results[j++] = new int[]{r0, c0};
                }
            }

            d = (d + 1) % 4;

        }
        return results;
    }

}
