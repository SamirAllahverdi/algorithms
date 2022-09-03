package hackerRank.recentImpls;

public class AlternatingCharacters {

    /**
     * - https://www.hackerrank.com/challenges/alternating-characters
     */

//    public static void main(String[] args) {
//        System.out.println(alternatingCharacters("AABBABAB"));
//    }


    public static int alternatingCharacters(String s) {
        int deletion = 0;
        char last = 'C';

        for (char el : s.toCharArray()) {
            if (last == el)
                deletion++;
            else
                last = el;
        }

        return deletion;
    }
}
