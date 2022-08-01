package hackerRank.recentImpls;

public class FindDigits {

    /***
     * - https://www.hackerrank.com/challenges/find-digits
     */
//    public static void main(String[] args) {
//        System.out.println(findDigits(124));
//    }

    public static int findDigits(int n) {

        int count = 0;
        int r = n;

        while (r > 0) {
            if (r % 10 != 0 && n % (r % 10) == 0) count++;
            r = r / 10;
        }

        return count;
    }

}
