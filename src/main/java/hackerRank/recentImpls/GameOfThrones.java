package hackerRank.recentImpls;

public class GameOfThrones {
    /**
     * - https://www.hackerrank.com/challenges/game-of-thrones/
     */

//    public static void main(String[] args) {
//        System.out.println(gameOfThrones("aaabbb"));
//    }
    public static String gameOfThrones(String s) {

        int[] chars = new int[26];

        for (char el : s.toCharArray())
            chars[el - 'a']++;


        int oddCount = 0;
        for (int el : chars)
            if (el % 2 != 0)
                oddCount++;


        return oddCount > 1 ? "NO" : "YES";
    }
}
