package newAlgorithms.hackerRank;

public class RepeatedString {
    /***
     * https://www.hackerrank.com/challenges/repeated-string/problem
     */

//    public static void main(String[] args) {
//        System.out.println(repeatedString("aba", 10));
//        System.out.println(repeatedString("a", 1000000000000L));
//    }

    public static long repeatedString(String s, long n) {

        int length = s.length();

        long occurrence = n / length;
        long reminder = n % length;

        long count = 0;
        long countInRemainder = 0;

        for (int a = 0; a < length; a++) {
            if (s.charAt(a) == 'a') {
                if (a < reminder) ++countInRemainder;
                ++count;
            }
        }

        return (count * occurrence) + countInRemainder;
    }
}
