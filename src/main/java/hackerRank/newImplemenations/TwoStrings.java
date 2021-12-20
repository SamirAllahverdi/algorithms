package hackerRank.newImplemenations;

public class TwoStrings {

    /**
     * https://www.hackerrank.com/challenges/two-strings
     */
//    public static void main(String[] args) {
//
//        String a = "wouldyoulikefries";
//        String b = "abcabcabcabcabcabc";
//        System.out.println(twoStrings(a, b)); /* expected NO */
//
//        String c = "hackerrankcommunity";
//        String d = "cdecdecdecde";
//        System.out.println(twoStrings(c, d)); /* expected YES */
//    }

    public static String twoStrings(String s1, String s2) {

        int[] chars = fillArray(s1);

        boolean isMatch = s2.chars().anyMatch(a -> chars[a - 'a'] > 0);

        return isMatch ? "YES" : "NO";
    }

    private static int[] fillArray(String s1) {
        int[] chars = new int[26];

        s1.chars().forEach(a -> chars[a - 'a']++);

        return chars;
    }


}
