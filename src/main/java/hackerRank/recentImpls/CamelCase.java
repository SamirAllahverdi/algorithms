package hackerRank.recentImpls;

public class CamelCase {

    /**
     * - https://www.hackerrank.com/challenges/camelcase
     */
//    public static void main(String[] args) {
//        System.out.println(camelcase("camelCase"));
//    }
    public static int camelcase(String s) {

        int wordCount = 1;
        for (char el : s.toCharArray())
            if (isUpperCase(el))
                wordCount++;

        return wordCount;
    }

    private static boolean isUpperCase(char el) {
        return el >= 65 && el <= 94;
    }
}
