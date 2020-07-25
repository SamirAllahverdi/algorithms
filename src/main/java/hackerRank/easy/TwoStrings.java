package hackerRank.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;

public class TwoStrings {
    /**
     * https://www.hackerrank.com/challenges/two-strings/problem
     */
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        System.out.println(twoStrings(s1, s2));

    }

    static String twoStrings(String s1, String s2) {

        HashSet<Character> hashSet = new HashSet<>();
        s1.chars().forEach(a -> hashSet.add((char) a));

        return hashSet.stream().anyMatch(a -> s2.contains(String.valueOf(a))) ? "YES" : "NO";
    }

//    FAILED IN 2 TEST CASES.
    static String twoStringsWithStream(String s1, String s2) {

        return IntStream.range(0, s1.length()).anyMatch(a -> s2.contains(String.valueOf(s1.charAt(a)))) ? "YES" : "NO";
    }

//    FAILED IN 2 TEST CASES, TOO.
    static String twoStringstest(String s1, String s2) {

        for(char c : s1.toCharArray()){
            if(s2.indexOf(c) > -1){
                return "YES";
            }
        }
        return "NO";
    }
}
