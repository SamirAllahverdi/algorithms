package hackerRank.recentImpls;

public class TheLoveLetterMystery {

    /**
     * - https://www.hackerrank.com/challenges/the-love-letter-mystery
     */

    public static int theLoveLetterMystery(String s) {
        int n = s.length();

        int count = 0;
        for (int a = 0; a < n / 2; a++) {

            int b = s.charAt(a);
            int c = s.charAt(n - 1 - a);

            if (b != c)
                count += Math.abs(b - c);
        }

        return count;
    }
}
