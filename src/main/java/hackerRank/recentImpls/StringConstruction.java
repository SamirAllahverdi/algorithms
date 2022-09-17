package hackerRank.recentImpls;

public class StringConstruction {


    /**
     * - https://www.hackerrank.com/challenges/string-construction
     */

//    public static void main(String[] args) {
//        System.out.println(stringConstruction("ababcd"));
//    }


    public static int stringConstruction(String s) {

        int[] letters = new int[26];

        int dollar = 0;
        for (char el : s.toCharArray()) {
            if (letters[el - 'a'] == 0) {
                dollar++;
                letters[el - 'a']++;
            }
        }

        return dollar;
    }
}
