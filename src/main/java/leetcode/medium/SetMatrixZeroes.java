package leetcode.medium;

import hackerRank.medium.TheBombermanGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {

    /**
     * https://leetcode.com/problems/set-matrix-zeroes/
     */

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        setZeroes(matrix);
        setZeroes2(matrix);

    }

    /***
     *  - first solution (naive approach) -
     */
    static class Location {
        int y;
        int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            Location location = (Location) o;
            return location.y == this.y && location.x == this.x;
        }

        @Override
        public int hashCode() {
            return y << 16 + x;
        }
    }

    public static void setZeroes(int[][] matrix) {
        List<Location> listLocations = new ArrayList<>();

        for (int a = 0; a < matrix.length; a++) {
            for (int b = 0; b < matrix[0].length; b++) {
                if (matrix[a][b] == 0) {
                    listLocations.add(new Location(a, b));
                }
            }
        }

        listLocations.forEach(a -> setting(a, matrix));

        Arrays.stream(matrix).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    private static void setting(Location l, int[][] matrix) {

        for (int x = 0; x < matrix[0].length; x++) {
            matrix[l.y][x] = 0;
        }

        for (int y = 0; y < matrix.length; y++) {
            matrix[y][l.x] = 0;

        }

    }

    /***
     *  - second solution  (time - O(M×N)) (space - O(1)) -
     */
    public static void setZeroes2(int[][] matrix) {
        boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
