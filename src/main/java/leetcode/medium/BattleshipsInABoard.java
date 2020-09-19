package leetcode.medium;

import hackerRank.medium.ConnectedCellsInAGrid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BattleshipsInABoard {


    /**
     * https://leetcode.com/problems/battleships-in-a-board/
     */


    public static void main(String[] args) {

        char[][] board = {{'X', '.', 'X', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(countBattleships(board));
    }

    /**
     * -  Solution -
     */

    public static int countBattleships(char[][] board) {

        int count = 0;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'X' && isValidBattleShip(row, col, board)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValidBattleShip(int row, int col, char[][] board) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        board[row][col] = '.';

        boolean horizon = false;
        boolean vertical = false;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            List<int[]> adjacents = fillArray(curr, board);

            for (int[] adjacent : adjacents) {

                if (adjacent[0] == curr[0]) {
                    horizon = true;
                }

                if (adjacent[1] == curr[1]) {
                    vertical = true;
                }

                board[adjacent[0]][adjacent[1]] = '.';
                queue.add(adjacent);
            }
        }


        return !horizon || !vertical;
    }

    private static List<int[]> fillArray(int[] curr, char[][] board) {
        return findPossibleAdjacents(curr).stream().filter(arr -> (arr[1] >= 0 && arr[1] < board[0].length)
                && (arr[0] >= 0 && arr[0] < board.length) && board[arr[0]][arr[1]] == 'X').collect(Collectors.toList());
    }

    private static List<int[]> findPossibleAdjacents(int[] curr) {
        return Arrays.asList(new int[]{curr[0] + 1, curr[1]},
                new int[]{curr[0] - 1, curr[1]},
                new int[]{curr[0], curr[1] + 1},
                new int[]{curr[0], curr[1] - 1}
        );
    }


    /**
     * -  IT IS NOT SOLUTION, I JUST LIKE THE STYLE AND RECURSIVE WAY -
     */

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int countBattleships2(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    count++;
                }
            }
        }
        return count;

    }

    public static void dfs(char[][] board, int i, int j) {
        if ((i >= 0 && i < board.length) && (j >= 0 && j < board[0].length) && board[i][j] == 'X') {
            board[i][j] = '.';
            for (int[] dir : dirs) {
                dfs(board, i + dir[0], j + dir[1]);
            }
        }
    }
}
