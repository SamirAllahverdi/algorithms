package hackerRank.recentImpls;

public class FunnyString {

    /**
     * -https://www.hackerrank.com/challenges/funny-string
     */
//    public static void main(String[] args) {
//        System.out.println(funnyString("lmnop"));
//    }
    public static String funnyString(String s) {
        int n = s.length();

        for (int a = 0; a < n - 1; a++)
            if (Math.abs(s.charAt(a) - s.charAt(a + 1)) != Math.abs(s.charAt(n - 1 - a) - s.charAt(n - 2 - a)))
                return "Not Funny";

        return "Funny";
    }
}
