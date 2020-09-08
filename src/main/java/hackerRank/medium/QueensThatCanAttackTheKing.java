package hackerRank.medium;

import java.util.*;

public class QueensThatCanAttackTheKing {

    /**
     * https://leetcode.com/problems/queens-that-can-attack-the-king/
     */
    public static void main(String[] args) {

        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] kings = {0, 0};

        System.out.println(queensAttackTheKing(queens, kings));
    }

    public static List<List<Integer>> queensAttackTheKing(int[][] queens, int[] king) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[][] queenPositions = new boolean[8][8];

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};

        for (int[] queen : queens) {
            queenPositions[queen[0]][queen[1]] = true;
        }

        for (int[] curr : directions) {

            int row = king[0];
            int col = king[1];

            while (isValid(row + curr[0], col + curr[1])) {

                row += curr[0];
                col += curr[1];

                if (queenPositions[row][col]) {
                    res.add(Arrays.asList(row, col));
                    break;
                }
            }
        }
        return res;
    }

    static boolean isValid(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}
