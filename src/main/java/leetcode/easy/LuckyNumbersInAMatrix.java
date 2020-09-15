package leetcode.easy;

import java.util.*;

public class LuckyNumbersInAMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            int minCol = minColInRow(matrix, row);
            int value = matrix[row][minCol];

            if (checkIfMaxInCol(matrix, minCol, value)) {
                result.add(value);
            }
        }

        return result;
    }

    private static int minColInRow(int[][] matrix, int row) {
        int min = Integer.MAX_VALUE, minIndex = 0;

        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] < min) {
                min = matrix[row][col];
                minIndex = col;
            }
        }

        return minIndex;
    }

    private static boolean checkIfMaxInCol(int[][] matrix, int col, int value) {
        for (int[] curr : matrix) {
            if (curr[col] > value) return false;
        }
        return true;
    }


}
