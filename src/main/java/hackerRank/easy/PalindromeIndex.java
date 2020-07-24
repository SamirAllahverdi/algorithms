package hackerRank.easy;

import java.util.stream.IntStream;

public class PalindromeIndex {


    /**
     * https://www.hackerrank.com/challenges/palindrome-index/problem
     */

    public static void main(String[] args) {
        String s = "aaab";
        System.out.println(palindromeIndex(s));


    }

    static int palindromeIndex(String s) {
        return IntStream.range(0, s.length() / 2).filter(a -> s.charAt(a) != s.charAt(s.length() - 1 - a)).
                map(a -> {
                    int b = s.length() - 1 - a;
                    if (isPalindrome(s, a)) {
                        return a;
                    } else if (isPalindrome(s, b)) {
                        return b;
                    } else {
                        return -1;
                    }
                }).filter(a -> a != -1).findFirst().orElse(-1);
    }


    static boolean isPalindrome(String s, int index) {
        StringBuilder st = builder(s,index);

        String tr = st.toString();
        String re = st.reverse().toString();

        return tr.equals(re);
    }

     static StringBuilder builder(String s, int index) {
        return new StringBuilder(s).deleteCharAt(index);
    }

}
