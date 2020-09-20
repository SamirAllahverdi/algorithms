package leetcode.medium;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    /**
     * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
     */

    public static void main(String[] args) {
        int n = 3;
        int k = 9;

        System.out.println(getHappyString(n, k));
    }


    static int k;

    public static String getHappyString(int n, int k) {

//        K is defined as class variable
        TheKthLexicographicalStringOfAllHappyStringsOfLengthN.k = k;

        return backtrack(n, 0, "");
    }

    private static String backtrack(int n, int i, String s) {

        if (i == n) return (--k == 0) ? s : "";

        for (char c = 'a'; c <= 'c'; c++) {

            if (!s.isEmpty() && s.charAt(s.length() - 1) == c) continue;

            String res = backtrack(n, i + 1, s + c);

            if (!res.isEmpty()) return res;

        }

        return "";
    }


}
