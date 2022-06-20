package hackerRank.recentImpls;

import java.util.HashSet;
import java.util.Set;

public class Panagram {

    /**
     * https://www.hackerrank.com/challenges/pangrams/problem?isFullScreen=true
     */
//    public static void main(String[] args) {
//        System.out.println(pangrams("    We promptly judged antique ivory buckles for the next prize"));
//    }


    public static String pangrams(String s) {
        return isPangram(s) ? "pangram" : "not pangram";
    }

    public static boolean isPangram(String s) {

        Set<String> set = new HashSet<>();

        for (Character ch : s.toCharArray())
            if (Character.isAlphabetic(ch))
                set.add(String.valueOf(ch).toLowerCase());


        return set.size() == 26;
    }
}
