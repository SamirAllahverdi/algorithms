package leetcode.medium;

public class WordSearch {

    /**
     * https://leetcode.com/problems/word-search/
     */
    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));

    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0) && isFound(board, i, j, word, 0))
                    return true;

        return false;
    }

    private static boolean isFound(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (word.charAt(index) != board[i][j]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        if (isFound(board, i + 1, j, word, index + 1) ||
                isFound(board, i - 1, j, word, index + 1) ||
                isFound(board, i, j + 1, word, index + 1) ||
                isFound(board, i, j - 1, word, index + 1)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}