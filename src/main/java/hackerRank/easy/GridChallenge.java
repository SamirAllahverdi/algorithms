package hackerRank.easy;

import java.util.Arrays;

public class GridChallenge {

    /**
     * https://www.hackerrank.com/challenges/grid-challenge/problem
     */
    public static void main(String[] args) {

        String[] grid = {"ebacd", "fghij", "olmkn", "trpqs", "xywuv"};

        System.out.println(gridChallenge(grid));

    }

    private static String gridChallenge(String[] grid) {

        int[][] array = fillIntArray(grid);

        sortArray(array);

        return isValid(array) ? "YES" : "NO";
    }

    private static boolean isValid(int[][] array) {
        for (int col = 0; col < array[0].length; col++) {
            for (int row = 0; row < array.length - 1; row++) {
                if (array[row][col] > array[row + 1][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void sortArray(int[][] array) {
        for (int[] row : array) {
            Arrays.sort(row);
        }
    }

    private static int[][] fillIntArray(String[] grid) {
        int[][] array = new int[grid.length][grid[0].length()];

        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[0].length(); b++) {
                array[a][b] = grid[a].charAt(b);
            }
        }

        return array;
    }


}
